package com.nyble.facades.kafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaConsumerFacade<K, V> {
    private final static Logger logger = LoggerFactory.getLogger(KafkaConsumerFacade.class);
    public final static int PROCESSING_TYPE_SINGLE = 1;
    public final static int PROCESSING_TYPE_BATCH = 2;

    private final Properties props;
    private int consumersNumber;
    private int processingType;
    private List<KafkaConsumer<K, V>> consumers;


    public KafkaConsumerFacade(Properties p, int consumersNumber, int processingType){
        this.consumersNumber = consumersNumber;
        this.processingType = processingType;
        this.props = p;
        this.props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        this.props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        this.props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 1000*60*2);
        this.consumers = new ArrayList<>();

        for(int i=0; i<consumersNumber; i++){
            final KafkaConsumer<K,V> consumer = new KafkaConsumer<>(p);
            consumers.add(consumer);
            Runtime.getRuntime().addShutdownHook(new Thread(()->{
                logger.info("Consumer shut down");
                consumer.close();
            }));
        }
    }

    public void subscribe(List<String> topics){
        for(KafkaConsumer<K, V> k : consumers){
            logger.info("Consumer subscribed to topics");
            k.subscribe(topics);
        }
    }

    public void startPolling(Duration waitForAtLeastOneRecordTimeout, Class<? extends RecordProcessor<K,V>> processorClass){
        try {
            Constructor<? extends RecordProcessor<K,V>> ctor = processorClass.getConstructor();
            for(KafkaConsumer<K, V> k : consumers){
                RecordProcessor<K,V> processor = ctor.newInstance();
                new KafkaConsumerPollLoopThread<>(k, waitForAtLeastOneRecordTimeout, processor, processingType)
                        .start();
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("No default constructor defined", e);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

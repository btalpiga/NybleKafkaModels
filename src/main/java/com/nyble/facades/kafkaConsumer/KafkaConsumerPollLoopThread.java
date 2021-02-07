package com.nyble.facades.kafkaConsumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;

public class KafkaConsumerPollLoopThread<K,V> extends Thread{

    private final static Logger logger = LoggerFactory.getLogger(KafkaConsumerPollLoopThread.class);
    private final KafkaConsumer<K,V> k;
    private final Duration timeout;
    private final RecordProcessor<K,V> processor;
    private final int processingType;
    private boolean notStopped = true;

    public KafkaConsumerPollLoopThread(KafkaConsumer<K,V> kafkaConsumer, Duration timeout,
                                       RecordProcessor<K, V> processor, int processingType){
        k=kafkaConsumer;
        this.timeout = timeout;
        this.processor = processor;
        this.processingType = processingType;
    }

    public void run(){
        ConsumerRecords<K, V> records;
        try{
            while((records = k.poll(timeout)) != null && notStopped){
                if(processingType == KafkaConsumerFacade.PROCESSING_TYPE_SINGLE){
                    Map<TopicPartition, List<ConsumerRecord<K,V>>> processed = new HashMap<>();
                    for(ConsumerRecord<K, V> record: records){
                        logger.debug("Start record processing");
                        try{
                            if(!processor.process(record)){
                                throw new Exception("code=kcplt_1");
                            }
                            processed.compute(new TopicPartition(record.topic(), record.partition()), (key, val)->{
                                if(val == null){
                                    val = new ArrayList<>();
                                }
                                val.add(record);
                                return val;
                            });
                        }catch(Exception e){
                            commitOffsets(k, new ConsumerRecords<>(processed));
                            if(Objects.equals(e.getMessage(), "code=kcplt_1")){
                                throw new RuntimeException(String
                                        .format("Record %s at topic %s, partition %d, offset %d processing returned false",
                                                record.value().toString(), record.topic(), record.partition(), record.offset()));
                            }else{
                                throw new RuntimeException(String
                                        .format("Could not process record %s at topic %s, partition %d, offset %d",
                                                record.value().toString(), record.topic(), record.partition(), record.offset()),
                                        e);
                            }
                        }
                    }
                }else if(processingType == KafkaConsumerFacade.PROCESSING_TYPE_BATCH){
                    try{
                        if(!processor.processBatch(records)){
                            throw new Exception("code=kcplt_1");
                        }
                    }catch(Exception e){
                        if(Objects.equals(e.getMessage(), "code=kcplt_1")){
                            throw new RuntimeException("Batch record processing failed");
                        }else{
                            throw new RuntimeException("Batch record processing failed",
                                    e);
                        }
                    }
                }

                try{
                    k.commitSync();
                }catch(CommitFailedException e){
                    logger.error(e.getMessage(), e);
                }
                logger.debug("End record processing");
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            logger.error("Thread {} is stopping...", this.getName());
        }finally {
            if(k != null){
                k.close();
            }
        }

    }

    private void commitOffsets(KafkaConsumer<K, V> consumer,ConsumerRecords<K, V> records){
        Map<TopicPartition, OffsetAndMetadata> offsetsToCommit = new HashMap<>();
        for (TopicPartition partition : records.partitions()) {
            List<ConsumerRecord<K, V>> partitionedRecords = records.records(partition);
            long offset = partitionedRecords.get(partitionedRecords.size() - 1).offset();
            offsetsToCommit.put(partition, new OffsetAndMetadata(offset + 1));
        }
        consumer.commitSync(offsetsToCommit);
    }

    public void finish(){
        this.notStopped = false;
    }
}

package com.nyble.managers;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;

public class ConsumerManager {

    private static ConsumerManager instance;
    private ConsumerManager() {
        kafkaConsumers = new HashMap<>();
    }

    public static ConsumerManager getInstance(){
        if(instance == null){
            instance = new ConsumerManager();
        }
        return instance;
    }

    private Map<TopicAndConsumerGroup, KafkaConsumer> kafkaConsumers;

    public void registerConsumer(TopicAndConsumerGroup topicAndConsumerGroup, KafkaConsumer consumer) throws IllegalAccessException {
        if(kafkaConsumers.containsKey(topicAndConsumerGroup)){
            throw new IllegalAccessException("Consumer already registered");
        }

        kafkaConsumers.put(topicAndConsumerGroup, consumer);
    }

    public KafkaConsumer registerConsumer(TopicAndConsumerGroup topicAndConsumerGroup, Properties p) throws IllegalAccessException {
        KafkaConsumer consumer = new KafkaConsumer(p);
        registerConsumer(topicAndConsumerGroup, consumer);

        consumer.subscribe(Collections.singleton(topicAndConsumerGroup.topicName));
        return consumer;
    }

    public KafkaConsumer<String, String> getConsumer(TopicAndConsumerGroup topicAndConsumerGroup){
        return kafkaConsumers.get(topicAndConsumerGroup);
    }

    public static class TopicAndConsumerGroup{
        public String consumerGroup;
        public String topicName;

        public TopicAndConsumerGroup(String topicName, String consumerGroup) {
            this.consumerGroup = consumerGroup;
            this.topicName = topicName;
        }

        @Override
        public int hashCode() {
            return Objects.hash(consumerGroup, topicName);
        }

        @Override
        public boolean equals(Object obj) {
            if( !(obj instanceof TopicAndConsumerGroup)){
                return false;
            }
            TopicAndConsumerGroup other = (TopicAndConsumerGroup) obj;
            return this.consumerGroup.equals(other.consumerGroup) && this.topicName.equals(other.topicName);
        }
    }
}


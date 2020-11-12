package com.nyble.facades.kafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

/***
 *
 * This interface should be implemented
 * There will be exactly one instance per KafkaConsumer
 * e.g. set no. of consumers to 4 in kafkaFacade => 4 instances
 * If all consumers need to share one object, then make it static at the RecordProcessor implementation level
 *
 * ***/
public interface RecordProcessor<K,V> {

    boolean process(ConsumerRecord<K, V> record);

    boolean processBatch(ConsumerRecords<K, V> records);
}

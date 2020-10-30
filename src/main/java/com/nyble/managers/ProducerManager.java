package com.nyble.managers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerManager {

    static private Object lock = new Object();
    static private Map<String, ProducerManager> producers = new ConcurrentHashMap<>();
    private KafkaProducer<String, String> producer;

//    public ProducerManager(Properties p){
//        producer = new KafkaProducer<>(p);
//    }

    protected ProducerManager(Properties p){
        producer = new KafkaProducer<>(p);
    }

    public static ProducerManager getInstance(Properties p){
        String producerName = "default";
        if(p.containsKey("name")){
            producerName = (String) p.remove("name");
        }

        if(producers.containsKey(producerName)){
            return producers.get(producerName);
        }else{
            synchronized (lock){
                if(producers.containsKey(producerName)){
                    return producers.get(producerName);
                }else{
                    ProducerManager mgr = new ProducerManager(p);
                    producers.put(producerName, mgr);
                    return mgr;
                }
            }
        }
    }


    public KafkaProducer<String, String> getProducer(){
        return producer;
    }
}


package com.nyble.topics.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nyble.models.consumer.Consumer;
import com.nyble.models.consumer.ConsumerAdapter;

import java.lang.reflect.Type;


public class ConsumerValue {

    private Consumer consumer;
    private ChangedProperty changedProperty;

    public ConsumerValue(Consumer consumer, ChangedProperty changedProperty) {
        this.consumer = consumer;
        this.changedProperty = changedProperty;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public ChangedProperty getChangedProperty() {
        return changedProperty;
    }

    public void setChangedProperty(ChangedProperty changedProperty) {
        this.changedProperty = changedProperty;
    }

    public static ConsumerValue fromJson(String jsonRep){
        return Consumer.getConsumerGson().fromJson(jsonRep, ConsumerValue.class);
    }
}

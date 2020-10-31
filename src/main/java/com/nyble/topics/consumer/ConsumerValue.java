package com.nyble.topics.consumer;

import com.nyble.models.consumer.Consumer;
import com.nyble.topics.JsonSerDes;
import com.nyble.topics.TopicObjectsFactory;


public class ConsumerValue implements JsonSerDes {

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


    @Override
    public String toJson() {
        return TopicObjectsFactory.getGson().toJson(this);
    }
}

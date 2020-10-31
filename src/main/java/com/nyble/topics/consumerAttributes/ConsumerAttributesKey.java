package com.nyble.topics.consumerAttributes;

import com.nyble.topics.JsonSerDes;
import com.nyble.topics.TopicObjectsFactory;

public class ConsumerAttributesKey implements JsonSerDes {

    private Integer systemId;
    private Integer consumerId;

    public ConsumerAttributesKey(Integer systemId, Integer consumerId) {
        this.systemId = systemId;
        this.consumerId = consumerId;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public String toJson() {
        return TopicObjectsFactory.getGson().toJson(this);
    }
}

package com.nyble.topics.consumer;

public class ConsumerKey {

    private Integer systemId;
    private Integer consumerId;

    public ConsumerKey(){}

    public ConsumerKey(Integer systemId, Integer consumerId) {
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
    public String toString() {
        return "ConsumerKey{" +
                "systemId=" + systemId +
                ", consumerId=" + consumerId +
                '}';
    }
}

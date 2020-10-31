package com.nyble.topics.consumerAttributes;

import com.nyble.topics.JsonSerDes;
import com.nyble.topics.TopicObjectsFactory;

public class ConsumerAttributesValue implements JsonSerDes {

    private String systemId;
    private String consumerId;
    private String key;
    private String value;
    private String externalSystemDate;
    private String localSystemDate;

    public ConsumerAttributesValue(){}

    public ConsumerAttributesValue(String systemId, String consumerId, String key, String value, String externalSystemDate, String localSystemDate) {
        this.systemId = systemId;
        this.consumerId = consumerId;
        this.key = key;
        this.value = value;
        this.externalSystemDate = externalSystemDate;
        this.localSystemDate = localSystemDate;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExternalSystemDate() {
        return externalSystemDate;
    }

    public void setExternalSystemDate(String externalSystemDate) {
        this.externalSystemDate = externalSystemDate;
    }

    public String getLocalSystemDate() {
        return localSystemDate;
    }

    public void setLocalSystemDate(String localSystemDate) {
        this.localSystemDate = localSystemDate;
    }

    @Override
    public String toString() {
        return "ConsumerAttributesValue{" +
                "systemId='" + systemId + '\'' +
                ", consumerId='" + consumerId + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", externalSystemDate='" + externalSystemDate + '\'' +
                ", localSystemDate='" + localSystemDate + '\'' +
                '}';
    }

    @Override
    public String toJson() {
        return TopicObjectsFactory.getGson().toJson(this);
    }
}

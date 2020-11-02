package com.nyble.topics.consumerActions;

import com.google.gson.annotations.Expose;
import com.nyble.topics.JsonSerDes;
import com.nyble.topics.TopicObjectsFactory;

import java.util.Objects;

public class ConsumerActionsValue implements JsonSerDes {

    private String id;
    private String actionId;
    private String consumerId;
    private String systemId;
    private ConsumerActionsPayload payloadJson;
    private String externalSystemDate;
    private String localSystemDate;

    public ConsumerActionsValue(String actionId, String consumerId, String systemId, ConsumerActionsPayload payloadJson,
                                String externalSystemDate, String localSystemDate) {
        this.actionId = actionId;
        this.consumerId = consumerId;
        this.systemId = systemId;
        this.payloadJson = payloadJson;
        this.externalSystemDate = externalSystemDate;
        this.localSystemDate = localSystemDate;
    }

    public ConsumerActionsValue(String id, String actionId, String consumerId, String systemId,
                                ConsumerActionsPayload payloadJson, String externalSystemDate, String localSystemDate) {
        this(actionId, consumerId, systemId, payloadJson, externalSystemDate, localSystemDate);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public ConsumerActionsPayload getPayloadJson() {
        return payloadJson;
    }

    public void setPayloadJson(ConsumerActionsPayload payloadJson) {
        this.payloadJson = payloadJson;
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
    public String toJson() {
        return TopicObjectsFactory.getGson().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumerActionsValue)) return false;
        ConsumerActionsValue that = (ConsumerActionsValue) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(actionId, that.actionId) &&
                Objects.equals(consumerId, that.consumerId) &&
                Objects.equals(systemId, that.systemId) &&
                Objects.equals(payloadJson, that.payloadJson) &&
                Objects.equals(externalSystemDate, that.externalSystemDate) &&
                Objects.equals(localSystemDate, that.localSystemDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionId, consumerId, systemId, payloadJson, externalSystemDate, localSystemDate);
    }

    public static class ConsumerActionsPayload {

        public String subcampaignId;
        public String posId;
        public String chanId;
        public String userId;
        public String prizeId;
        public String valGain;
        public String valSpend;
        public String externalId;
        public String touchpointId;

        @Expose(serialize = false)
        private String raw;

        private Value value;

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getRaw(){
            return raw;
        }

        public ConsumerActionsPayload(String subcampaignId, String posId, String chanId, String userId, String prizeId,
                                      String valGain, String valSpend, String externalId, String touchpointId) {
            this.subcampaignId = subcampaignId;
            this.posId = posId;
            this.chanId = chanId;
            this.userId = userId;
            this.prizeId = prizeId;
            this.valGain = valGain;
            this.valSpend = valSpend;
            this.externalId = externalId;
            this.touchpointId = touchpointId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ConsumerActionsPayload)) return false;
            ConsumerActionsPayload that = (ConsumerActionsPayload) o;
            return Objects.equals(subcampaignId, that.subcampaignId) &&
                    Objects.equals(posId, that.posId) &&
                    Objects.equals(chanId, that.chanId) &&
                    Objects.equals(userId, that.userId) &&
                    Objects.equals(prizeId, that.prizeId) &&
                    Objects.equals(valGain, that.valGain) &&
                    Objects.equals(valSpend, that.valSpend) &&
                    Objects.equals(externalId, that.externalId) &&
                    Objects.equals(touchpointId, that.touchpointId) &&
                    Objects.equals(raw, that.raw) &&
                    Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(subcampaignId, posId, chanId, userId, prizeId, valGain, valSpend, externalId, touchpointId, raw, value);
        }

        public static class Value{
            public String sku_quantity;
            public String new_value;
            public String old_value;
            public String sku_bought;

            public Boolean getNewValueAsBool(){
                if (new_value == null){
                    return null;
                }

                if(new_value.trim().equalsIgnoreCase("true") || new_value.trim().equalsIgnoreCase("false")){
                    return Boolean.valueOf(new_value);
                }
                return null;
            }

            public Boolean getOldValueAsBool(){
                if (old_value == null){
                    return null;
                }

                if(old_value.trim().equalsIgnoreCase("true") || old_value.trim().equalsIgnoreCase("false")){
                    return Boolean.valueOf(old_value);
                }
                return null;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Value)) return false;
                Value value = (Value) o;
                return Objects.equals(sku_quantity, value.sku_quantity) &&
                        Objects.equals(new_value, value.new_value) &&
                        Objects.equals(old_value, value.old_value) &&
                        Objects.equals(sku_bought, value.sku_bought);
            }

            @Override
            public int hashCode() {
                return Objects.hash(sku_quantity, new_value, old_value, sku_bought);
            }
        }
    }
}

package com.nyble.topics.consumerActions;

import com.google.gson.*;
import com.google.gson.internal.GsonBuildConfig;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ConsumerActionsValue {

    private int id;
    private int actionId;
    private int consumerId;
    private int systemId;
    private ConsumerActionsPayload payloadJson;
    private String externalSystemDate;
    private String localSystemDate;

//    private static final GsonBuilder gsonBuilder = new GsonBuilder();
//    private static final Type consumerActionsValueType = new TypeToken<ConsumerActionsValue>(){}.getType();
//    static{
//        gsonBuilder.registerTypeAdapter(consumerActionsValueType, new JsonDeserializer<ConsumerActionsValue>(){
//
//            @Override
//            public ConsumerActionsValue deserialize(JsonElement jsonElement, Type type,
//                                                    JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//                return null;
//            }
//        });
//    }
    final static Gson innerGson = new Gson();
    public static ConsumerActionsValue fromJson(String jsonRep){
        if(jsonRep == null || jsonRep.isEmpty()){
            return null;
        }

        jsonRep = jsonRep.replaceAll("[\\\\]+\"", "\"")
            .replaceAll("\"\\{", "{")
                .replaceAll("\\}\"", "}");
        return innerGson.fromJson(jsonRep, ConsumerActionsValue.class);
    }

    public ConsumerActionsValue(int actionId, int consumerId, int systemId, ConsumerActionsPayload payloadJson,
                                String externalSystemDate, String localSystemDate) {
        this.actionId = actionId;
        this.consumerId = consumerId;
        this.systemId = systemId;
        this.payloadJson = payloadJson;
        this.externalSystemDate = externalSystemDate;
        this.localSystemDate = localSystemDate;
    }

    public ConsumerActionsValue(int id, int actionId, int consumerId, int systemId,
                                ConsumerActionsPayload payloadJson, String externalSystemDate, String localSystemDate) {
        this(actionId, consumerId, systemId, payloadJson, externalSystemDate, localSystemDate);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
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


    public static class ConsumerActionsPayload {
        public Integer subcampaignId;
        public Integer sku_quantity;
        public String new_value;
        public String old_value;
        public String sku_bought;

        public ConsumerActionsPayload(Integer subcampaignId, Integer sku_quantity, String new_value, String old_value, String sku_bought) {
            this.subcampaignId = subcampaignId;
            this.sku_quantity = sku_quantity;
            this.new_value = new_value;
            this.old_value = old_value;
            this.sku_bought = sku_bought;
        }

        public Integer getSubcampaignId() {
            return subcampaignId;
        }

        public void setSubcampaignId(Integer subcampaignId) {
            this.subcampaignId = subcampaignId;
        }

        public Integer getSku_quantity() {
            return sku_quantity;
        }

        public void setSku_quantity(int sku_quantity) {
            this.sku_quantity = sku_quantity;
        }

        public String getNew_value() {
            return new_value;
        }

        public void setNew_value(String new_value) {
            this.new_value = new_value;
        }

        public String getOld_value() {
            return old_value;
        }

        public void setOld_value(String old_value) {
            this.old_value = old_value;
        }

        public void setSku_quantity(Integer sku_quantity) {
            this.sku_quantity = sku_quantity;
        }

        public String getSku_bought() {
            return sku_bought;
        }

        public void setSku_bought(String sku_bought) {
            this.sku_bought = sku_bought;
        }

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
    }
}

package com.nyble.topics.consumerActions;

import com.google.gson.*;
import com.google.gson.stream.JsonToken;

import java.lang.reflect.Type;
import java.util.Map;

public class ConsumerActionDeserializer implements JsonDeserializer<ConsumerActionsValue> {
    @Override
    public ConsumerActionsValue deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject obj = (JsonObject) jsonElement;
        String actionId = getProperty(obj, "actionId");
        String id = getProperty(obj, "id");
        String consumerId = getProperty(obj, "consumerId");
        String systemId = getProperty(obj, "systemId");
        String externalSystemDate = getProperty(obj, "externalSystemDate");
        String localSystemDate = getProperty(obj, "localSystemDate");
        String payloadJsonRaw = getProperty(obj, "payloadJson");
        if(payloadJsonRaw == null){
            return new ConsumerActionsValue(id, actionId, consumerId, systemId, null,
                    externalSystemDate, localSystemDate);
        }
        JsonObject payloadJsonObject = (JsonObject) new JsonParser().parse(payloadJsonRaw);
        ConsumerActionsValue.ConsumerActionsPayload payloadJson = new ConsumerActionsValue.ConsumerActionsPayload(
                getProperty(payloadJsonObject,"subcampaignId"), getProperty(payloadJsonObject,"posId"),
                getProperty(payloadJsonObject,"chanId"), getProperty(payloadJsonObject,"userId"),
                getProperty(payloadJsonObject,"prizeId"), getProperty(payloadJsonObject,"valGain"),
                getProperty(payloadJsonObject,"valSpend"), getProperty(payloadJsonObject,"externalId"),
                getProperty(payloadJsonObject,"touchpointId"));
        payloadJson.setRaw(payloadJsonRaw);

        JsonElement valueElement= payloadJsonObject.has("value") && !payloadJsonObject.get("value").isJsonNull() ?
            payloadJsonObject.get("value") : null;

        if(valueElement != null && valueElement.isJsonObject()){
            JsonObject valueObject = valueElement.getAsJsonObject();
            ConsumerActionsValue.ConsumerActionsPayload.Value value = new ConsumerActionsValue.ConsumerActionsPayload.Value();
            value.sku_bought = getProperty(valueObject, "sku_bought");
            value.new_value = getProperty(valueObject, "new_value");
            value.old_value = getProperty(valueObject, "old_value");
            value.sku_quantity = getProperty(valueObject, "sku_quantity");
            payloadJson.setValue(value);
        }


        return new ConsumerActionsValue(id, actionId, consumerId, systemId, payloadJson,
                externalSystemDate, localSystemDate);
    }
    
    private String getProperty(JsonObject obj, String propName){
        if(obj.has(propName) && !obj.get(propName).isJsonNull()){
            return obj.get(propName).getAsString();
        }
        return null;
    }
}

package com.nyble.topics.consumerActions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ConsumerActionSerializer implements JsonSerializer<ConsumerActionsValue> {

    @Override
    public JsonElement serialize(ConsumerActionsValue cav, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", cav.getId());
        jsonObject.addProperty("actionId", cav.getActionId());
        jsonObject.addProperty("systemId", cav.getSystemId());
        jsonObject.addProperty("consumerId", cav.getConsumerId());
        jsonObject.addProperty("externalSystemDate", cav.getExternalSystemDate());
        jsonObject.addProperty("localSystemDate", cav.getLocalSystemDate());
        jsonObject.addProperty("payloadJson", cav.getPayloadJson()==null ? null : cav.getPayloadJson().getRaw());
        return jsonObject;
    }
}

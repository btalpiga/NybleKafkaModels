package com.nyble.models.consumer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Map;

public class ConsumerSerializer implements JsonSerializer<Consumer> {

    @Override
    public JsonElement serialize(Consumer consumer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonConsumer = new JsonObject();
        for(Map.Entry<String, CAttribute> prop : consumer.getAllProperties()){
            CAttribute attribute = prop.getValue();
            JsonObject objectAttribute = new JsonObject();
            objectAttribute.addProperty("value", attribute.getValue());
            objectAttribute.addProperty("lut", attribute.getLut());
            jsonConsumer.add(prop.getKey(), objectAttribute);
        }

        return jsonConsumer;
    }
}

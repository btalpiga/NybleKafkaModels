package com.nyble.models.consumer;

import com.google.gson.*;
import com.google.gson.stream.JsonToken;

import java.lang.reflect.Type;
import java.util.Map;

public class ConsumerDeserializer implements JsonDeserializer<Consumer> {
    @Override
    public Consumer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Consumer c = new Consumer();

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        for(Map.Entry<String, JsonElement> e: jsonObject.entrySet()){
            String attributeName = e.getKey();
            JsonObject cAttributeJson = e.getValue().getAsJsonObject();
            JsonElement value = cAttributeJson.get("value");
            String valueStr = null;
            if(value != null && !value.isJsonNull()){
                valueStr = value.getAsString();
            }
            CAttribute cAttribute = new CAttribute(valueStr,
                    cAttributeJson.get("lut").getAsString());
            c.setProperty(attributeName, cAttribute);
        }
        return c;
    }
}

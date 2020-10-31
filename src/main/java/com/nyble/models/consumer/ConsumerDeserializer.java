package com.nyble.models.consumer;

import com.google.gson.*;

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
            CAttribute cAttribute = new CAttribute(cAttributeJson.get("value").getAsString(),
                    cAttributeJson.get("lut").getAsString());
            c.setProperty(attributeName, cAttribute);
        }
        return c;
    }
}

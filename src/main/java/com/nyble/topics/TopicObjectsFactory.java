package com.nyble.topics;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nyble.models.consumer.Consumer;
import com.nyble.models.consumer.ConsumerDeserializer;
import com.nyble.models.consumer.ConsumerSerializer;
import com.nyble.topics.consumer.ConsumerKey;
import com.nyble.topics.consumer.ConsumerValue;
import com.nyble.topics.consumerActions.ConsumerActionsKey;
import com.nyble.topics.consumerActions.ConsumerActionsValue;
import com.nyble.topics.consumerAttributes.ConsumerAttributesKey;
import com.nyble.topics.consumerAttributes.ConsumerAttributesValue;

import java.lang.reflect.Type;

public class TopicObjectsFactory {

    private final static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson localGson;
    static{
        Type consumerType = new TypeToken<Consumer>(){}.getType();

        localGson = gsonBuilder
                .registerTypeAdapter(consumerType, new ConsumerDeserializer())
                .registerTypeAdapter(consumerType, new ConsumerSerializer())
                .create();
    }

    public static Gson getGson(){
        return localGson;
    }

    public static JsonSerDes fromJson(String json, Class<?> type){
        if(type.equals(ConsumerAttributesKey.class)){
            return localGson.fromJson(json, ConsumerAttributesKey.class);
        }

        else if(type.equals(ConsumerAttributesValue.class)){
            return localGson.fromJson(json, ConsumerAttributesValue.class);
        }

        else if(type.equals(ConsumerActionsKey.class)){
            return localGson.fromJson(json, ConsumerActionsKey.class);
        }

        else if(type.equals(ConsumerActionsValue.class)){
            if(json == null || json.isEmpty()){
                return null;
            }

            int startIdx = json.indexOf("\"{");
            String rawConsumerActionJson = null;
            if(startIdx >= 0){
                int endIdx = json.indexOf("}\"", startIdx) + "}\"".length();
                String start = json.substring(0, startIdx);
                String end = json.substring(endIdx);
                rawConsumerActionJson = json.substring(startIdx, endIdx)
                        .replaceAll("[\\\\]+\"", "\"")
                        .replaceAll("\"\\{", "{")
                        .replaceAll("\\}\"", "}");
                json = start+rawConsumerActionJson+end;
            }
            json = json.replaceAll("[\\\\]+\"", "\"")
                    .replaceAll("\"\\{", "{")
                    .replaceAll("\\}\"", "}");
            ConsumerActionsValue cav = localGson.fromJson(json, ConsumerActionsValue.class);
            if(cav.getPayloadJson() != null){
                cav.getPayloadJson().setRaw(rawConsumerActionJson);
            }
            return cav;
        }

        else if(type.equals(ConsumerKey.class)){
            return localGson.fromJson(json, ConsumerKey.class);
        }

        else if(type.equals(ConsumerValue.class)){
            return localGson.fromJson(json, ConsumerValue.class);
        }

        else if(type.equals(Consumer.class)){
            return localGson.fromJson(json, Consumer.class);
        }

        else return null;
    }

}

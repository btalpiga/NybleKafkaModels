import com.nyble.models.consumer.Consumer;
import com.nyble.topics.TopicObjectsFactory;
import com.nyble.topics.consumer.ChangedProperty;
import com.nyble.topics.consumer.ConsumerValue;
import com.nyble.topics.consumerActions.ConsumerActionsValue;
import com.nyble.topics.consumerAttributes.ConsumerAttributesValue;
import junit.framework.TestCase;

public class TestSerializeDeserialize  extends TestCase {

    public void testAttributeKafkaMessage(){
        final String msg = "{\"systemId\":\"1\",\"consumerId\":\"11302890\",\"key\":\"webInCnt\",\"value\":\"4610\",\"externalSystemDate\":\"1603029148327\",\"localSystemDate\":\"1603029148327\"}";
        ConsumerAttributesValue deserialized = (ConsumerAttributesValue) TopicObjectsFactory
                .fromJson(msg, ConsumerAttributesValue.class);
        //assert values
        assertNotNull(deserialized);
        assertEquals(deserialized.getSystemId(), "1");
        assertEquals(deserialized.getConsumerId(), "11302890");
        assertEquals(deserialized.getKey(), "webInCnt");
        assertEquals(deserialized.getValue(), "4610");
        assertEquals(deserialized.getExternalSystemDate(), "1603029148327");


        String serialized = deserialized.toJson();
        assertNotNull(serialized);
        assertEquals(msg, serialized);
    }

    public void testAttributeKafkaMessage_null(){
        final String msg = null;
        ConsumerAttributesValue deserialized = (ConsumerAttributesValue) TopicObjectsFactory
                .fromJson(msg, ConsumerAttributesValue.class);
        assertNull(deserialized);

    }

    public void testAttributeKafkaMessage_empty(){
        final String msg = "";
        ConsumerAttributesValue deserialized = (ConsumerAttributesValue) TopicObjectsFactory
                .fromJson(msg, ConsumerAttributesValue.class);
        assertNull(deserialized);
    }



    public void testActionKafkaMessage(){
        final String msg = "{\"id\":658221427,\"systemId\":1,\"consumerId\":11462423,\"actionId\":2091,\"payloadJson\":" +
                "\"{\\\"posId\\\": null, \\\"value\\\": null, \\\"chanId\\\": \\\"2\\\", \\\"userId\\\": \\\"0\\\", " +
                    "\\\"prizeId\\\": null, \\\"valGain\\\": null, \\\"valSpend\\\": null, \\\"externalId\\\": null, " +
                    "\\\"touchpointId\\\": null, \\\"subcampaignId\\\": \\\"4603\\\"" +
                "}\"," +
                "\"externalSystemDate\":\"1603275483000\",\"localSystemDate\":\"1603275496350\"}";
        ConsumerActionsValue deserialized = (ConsumerActionsValue) TopicObjectsFactory
                .fromJson(msg, ConsumerActionsValue.class);
        //assert values
        assertNotNull(deserialized);
        assertEquals(deserialized.getId(), "658221427");
        assertEquals(deserialized.getSystemId(), "1");
        assertEquals(deserialized.getConsumerId(), "11462423");
        assertEquals(deserialized.getActionId(), "2091");
        assertEquals(deserialized.getLocalSystemDate(), "1603275496350");
        assertEquals(deserialized.getExternalSystemDate(), "1603275483000");

        ConsumerActionsValue.ConsumerActionsPayload payload = deserialized.getPayloadJson();
        assertNotNull(payload);
        assertEquals(payload.subcampaignId, "4603");
        assertEquals(payload.chanId, "2");
        assertEquals(payload.userId, "0");
        assertNull(payload.valSpend);
        assertEquals(payload.getRaw(), "{\"posId\": null, \"value\": null, \"chanId\": \"2\", \"userId\": \"0\", " +
                        "\"prizeId\": null, \"valGain\": null, \"valSpend\": null, \"externalId\": null, " +
                        "\"touchpointId\": null, \"subcampaignId\": \"4603\"" +
                        "}");

        ConsumerActionsValue.ConsumerActionsPayload.Value actionValue = payload.getValue();
        assertNull(actionValue);

        String serialized = deserialized.toJson();
        assertNotNull(serialized);
//        assertEquals(msg, serialized);
    }

    public void testActionKafkaMessage_null(){
        final String msg = null;
        ConsumerActionsValue deserialized = (ConsumerActionsValue) TopicObjectsFactory
                .fromJson(msg, ConsumerActionsValue.class);
        assertNull(deserialized);

    }

    public void testActionKafkaMessage_empty(){
        final String msg = "";
        ConsumerActionsValue deserialized = (ConsumerActionsValue) TopicObjectsFactory
                .fromJson(msg, ConsumerActionsValue.class);
        assertNull(deserialized);

    }





    public void testConsumerKafkaMessage(){
        final String msg = "{\"consumer\":" +
                "{" +
                "\"systemId\":{\"value\":\"1\",\"lut\":\"1601240400000\"}," +
                "\"affinity_127\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"affinity_138\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"consumerId\":{\"value\":\"7494834\",\"lut\":\"1601240400000\"}," +
                "\"affinity_125\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"affinity_117\":{\"value\":\"0\",\"lut\":\"1601240400000\"}" +
                "}," +
                "\"changedProperty\":{\"propertyName\":\"fullName\"}}";
        ConsumerValue deserialized = (ConsumerValue) TopicObjectsFactory
                .fromJson(msg, ConsumerValue.class);
        //assert values
        assertNotNull(deserialized);
        Consumer consumer = deserialized.getConsumer();
        assertNotNull(consumer);
        ChangedProperty changedProperty = deserialized.getChangedProperty();
        assertNotNull(changedProperty);

        assertEquals(consumer.getAllProperties().size(), 6);
        assertEquals(consumer.getValue("consumerId"), "7494834");
        assertEquals(consumer.getValue("systemId"), "1");
        assertEquals(consumer.getValue("affinity_127"), "0");
        assertEquals(consumer.getValue("affinity_125"), "0");
        assertEquals(consumer.getValue("affinity_117"), "0");
        assertEquals(consumer.getValue("affinity_138"), "0");

        assertEquals(changedProperty.getPropertyName(), "fullName");

        String serialized = deserialized.toJson();
        assertNotNull(serialized);
        assertEquals(msg, serialized);
    }

    public void testConsumerKafkaMessage_null(){
        final String msg = null;
        ConsumerValue deserialized = (ConsumerValue) TopicObjectsFactory
                .fromJson(msg, ConsumerValue.class);
        assertNull(deserialized);

    }

    public void testConsumerKafkaMessage_empty(){
        final String msg = "";
        ConsumerValue deserialized = (ConsumerValue) TopicObjectsFactory
                .fromJson(msg, ConsumerValue.class);
        assertNull(deserialized);
    }




    public void testConsumer(){
        final String msg = "{" +
                "\"systemId\":{\"value\":\"1\",\"lut\":\"1601240400000\"}," +
                "\"affinity_127\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"affinity_138\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"consumerId\":{\"value\":\"7494834\",\"lut\":\"1601240400000\"}," +
                "\"affinity_125\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"affinity_117\":{\"value\":\"0\",\"lut\":\"1601240400000\"}" +
                "}";
        Consumer deserialized = (Consumer) TopicObjectsFactory
                .fromJson(msg, Consumer.class);
        //assert values
        assertNotNull(deserialized);

        assertEquals(deserialized.getAllProperties().size(), 6);
        assertEquals(deserialized.getValue("consumerId"), "7494834");
        assertEquals(deserialized.getValue("systemId"), "1");
        assertEquals(deserialized.getValue("affinity_127"), "0");
        assertEquals(deserialized.getValue("affinity_125"), "0");
        assertEquals(deserialized.getValue("affinity_117"), "0");
        assertEquals(deserialized.getValue("affinity_138"), "0");

        String serialized = deserialized.toJson();
        assertNotNull(serialized);
        assertEquals(msg, serialized);
    }

    public void testConsumer_null(){
        final String msg = null;
        Consumer deserialized = (Consumer) TopicObjectsFactory
                .fromJson(msg, Consumer.class);
        assertNull(deserialized);
    }

    public void testConsumer_empty(){
        final String msg = "";
        Consumer deserialized = (Consumer) TopicObjectsFactory
                .fromJson(msg, Consumer.class);
        assertNull(deserialized);
    }
}

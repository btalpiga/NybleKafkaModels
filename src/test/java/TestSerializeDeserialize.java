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


    public void testActionKafkaMessage_3(){
        final String msg = "{\n" +
                "  \"id\": 658924521,\n" +
                "  \"systemId\": 1,\n" +
                "  \"consumerId\": 12066431,\n" +
                "  \"actionId\": 1740,\n" +
                "  \"payloadJson\": \"{\\\"posId\\\": \\\"724123\\\", " +
                    "\\\"value\\\": {\\\"sob\\\": false, \\\"city\\\": \\\"ORADEA\\\", \\\"email\\\": \\\"ciprianboc@yahoo.com\\\", " +
                    "\\\"phone\\\": \\\"0724801775\\\", \\\"prize\\\": \\\"Un pachet Sobranie Redefined Blue\\\", \\\"county\\\": \\\"BIHOR\\\", \\\"gender\\\": \\\"M\\\", \\\"opt_in\\\": true, \\\"nfc_tag\\\": null, \\\"with_ci\\\": false, \\\"lastname\\\": \\\"Boc\\\", \\\"pos_area\\\": \\\"AREA WEST\\\", " +
                    "\\\"pos_city\\\": \\\"ORADEA\\\", \\\"pos_code\\\": \\\"BHR00960\\\", \\\"pos_name\\\": \\\"VALERY ABC SRL\\\", \\\"birthdate\\\": \\\"1990-10-17\\\", \\\"cigarette\\\": \\\"Redefined Blue (5 mg)\\\", \\\"firstname\\\": \\\"Cirian\\\", \\\"in_matrix\\\": true, \\\"address_no\\\": \\\"60\\\", " +
                    "\\\"opt_in_sms\\\": true, \\\"pos_county\\\": \\\"BIHOR\\\", \\\"sku_bought\\\": \\\"SBRFBL\\\", \\\"consumer_id\\\": 12066431, \\\"opt_in_email\\\": null, \\\"pos_city_121\\\": \\\"ORADEA\\\", " +
                    "\\\"prize_sku_qr\\\": \\\"[\\\\\\\"5RLECNI:Ta4bQfInc0002e620080822\\\\\\\"]\\\", \\\"sku_quantity\\\": \\\"2\\\", \\\"address_floor\\\": \\\"\\\", \\\"cigarette_sku\\\": \\\"SBRFBL\\\", \\\"confirmed_sms\\\": true, \\\"one2one_ba_id\\\": \\\"43869\\\", " +
                    "\\\"sku_bought_qr\\\": \\\"[\\\\\\\"5RLECNI:oFidbAeh50002ji20083010\\\\\\\",\\\\\\\"5RLECNI:dQ1aA9hN20002ji20083010\\\\\\\"]\\\", \\\"address_street\\\": \\\"Costaforu\\\", \\\"logic_products\\\": 0, \\\"cigarette_brand\\\": \\\"Sobranie\\\", " +
                    "\\\"contact_comment\\\": \\\"\\\", \\\"address_building\\\": \\\"\\\", \\\"address_entrance\\\": \\\"\\\", \\\"opt_in_marketing\\\": true, \\\"pos_sales_office\\\": \\\"SALES OFFICE BIHOR\\\", \\\"address_apartment\\\": \\\"\\\", " +
                    "\\\"one2one_ba_agency\\\": \\\"Wave\\\", \\\"one2one_contact_id\\\": \\\"41277\\\", \\\"address_street_type\\\": \\\"Strada\\\", \\\"one2one_campaign_id\\\": \\\"566\\\", \\\"one2one_contact_date\\\": \\\"2020-10-23 14:48:54\\\", \\\"opt_in_postaladdress\\\": true, " +
                    "\\\"one2one_campaign_name\\\": \\\"CCC GFB 2020\\\", \\\"one2one_campaign_type\\\": \\\"Teren\\\", \\\"opt_in_sms_validation\\\": false, \\\"one2one_contact_crm_id\\\": 12066431, \\\"opt_in_market_analysis\\\": true, \\\"opt_in_communication_dm\\\": true, \\\"opt_in_email_validation\\\": true, \\\"one2one_campaign_channel\\\": \\\"RTL\\\", " +
                    "\\\"one2one_campaign_hr_name\\\": \\\"566 Multibrand retail val 6\\\", \\\"opt_in_communication_sms\\\": true, \\\"one2one_campaign_brand_id\\\": \\\"3\\\", \\\"contact_send_singnup_email\\\": true, \\\"opt_in_communication_email\\\": true, \\\"one2one_campaign_brand_name\\\": \\\"Winston \\u0026 Sobranie\\\"}, \\\"chanId\\\": \\\"2\\\", " +
                    "\\\"userId\\\": \\\"0\\\", \\\"prizeId\\\": null, \\\"valGain\\\": null, \\\"valSpend\\\": null, \\\"externalId\\\": null, \\\"touchpointId\\\": null, \\\"subcampaignId\\\": \\\"5621\\\"}\",\n" +
                "  \"externalSystemDate\": \"1603453734000\",\n" +
                "  \"localSystemDate\": \"1603453986201\"\n" +
                "}";
        ConsumerActionsValue deserialized = (ConsumerActionsValue) TopicObjectsFactory
                .fromJson(msg, ConsumerActionsValue.class);
        //assert values
        assertNotNull(deserialized);
        assertEquals(deserialized.getId(), "658924521");
        assertEquals(deserialized.getSystemId(), "1");
        assertEquals(deserialized.getConsumerId(), "12066431");
        assertEquals(deserialized.getActionId(), "1740");
        assertEquals(deserialized.getLocalSystemDate(), "1603453986201");
        assertEquals(deserialized.getExternalSystemDate(), "1603453734000");

        ConsumerActionsValue.ConsumerActionsPayload payload = deserialized.getPayloadJson();
        assertNotNull(payload);
        assertEquals(payload.subcampaignId, "5621");
        assertEquals(payload.chanId, "2");
        assertEquals(payload.userId, "0");
        assertNull(payload.valSpend);
//        assertEquals( "{" +
//                "\"posId\": null, " +
//                "\"value\": null, " +
//                "\"chanId\": \"5\", " +
//                "\"userId\": \"0\", " +
//                "\"prizeId\": null, " +
//                "\"valGain\": null, " +
//                "\"valSpend\": null, " +
//                "\"externalId\": null, " +
//                "\"touchpointId\": \"2\", " +
//                "\"subcampaignId\": \"5362\"" +
//                "}", payload.getRaw());

        ConsumerActionsValue.ConsumerActionsPayload.Value actionValue = payload.getValue();
        assertNotNull(actionValue);

        String serialized = deserialized.toJson();
        assertNotNull(serialized);
        assertEquals(deserialized, TopicObjectsFactory.fromJson(serialized, ConsumerActionsValue.class));
    }

    public void testActionKafkaMessage_2(){
        final String msg = "{" +
                "\"id\":659634844," +
                "\"systemId\":1," +
                "\"consumerId\":11986763," +
                "\"actionId\":1778," +
                "\"payloadJson\":\"{" +
                    "\\\"posId\\\": null, " +
                    "\\\"value\\\": {" +
                        "\\\"code\\\": \\\"LMHN1UCKU\\\", " +
                        "\\\"platform\\\": \\\"web\\\"" +
                    "}, " +
                    "\\\"chanId\\\": \\\"5\\\", " +
                    "\\\"userId\\\": \\\"0\\\", " +
                    "\\\"prizeId\\\": null, " +
                    "\\\"valGain\\\": null, " +
                    "\\\"valSpend\\\": null, " +
                    "\\\"externalId\\\": null, " +
                    "\\\"touchpointId\\\": \\\"2\\\", " +
                    "\\\"subcampaignId\\\": \\\"5362\\\"" +
                "}\"," +
                "\"externalSystemDate\":\"1603652615000\"," +
                "\"localSystemDate\":\"1603699039951\"}";
        ConsumerActionsValue deserialized = (ConsumerActionsValue) TopicObjectsFactory
                .fromJson(msg, ConsumerActionsValue.class);
        //assert values
        assertNotNull(deserialized);
        assertEquals(deserialized.getId(), "659634844");
        assertEquals(deserialized.getSystemId(), "1");
        assertEquals(deserialized.getConsumerId(), "11986763");
        assertEquals(deserialized.getActionId(), "1778");
        assertEquals(deserialized.getLocalSystemDate(), "1603699039951");
        assertEquals(deserialized.getExternalSystemDate(), "1603652615000");

        ConsumerActionsValue.ConsumerActionsPayload payload = deserialized.getPayloadJson();
        assertNotNull(payload);
        assertEquals(payload.subcampaignId, "5362");
        assertEquals(payload.chanId, "5");
        assertEquals(payload.userId, "0");
        assertNull(payload.valSpend);
        assertEquals(payload.getRaw(), "{" +
                "\"posId\": null, " +
                "\"value\": {" +
                    "\"code\": \"LMHN1UCKU\", " +
                    "\"platform\": \"web\"" +
                "}, " +
                "\"chanId\": \"5\", " +
                "\"userId\": \"0\", " +
                "\"prizeId\": null, " +
                "\"valGain\": null, " +
                "\"valSpend\": null, " +
                "\"externalId\": null, " +
                "\"touchpointId\": \"2\", " +
                "\"subcampaignId\": \"5362\"" +
                "}");

        ConsumerActionsValue.ConsumerActionsPayload.Value actionValue = payload.getValue();
        assertNotNull(actionValue);

        String serialized = deserialized.toJson();
        assertNotNull(serialized);
        assertEquals(deserialized, TopicObjectsFactory.fromJson(serialized, ConsumerActionsValue.class));
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
        assertEquals(deserialized, TopicObjectsFactory.fromJson(serialized, ConsumerActionsValue.class));
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

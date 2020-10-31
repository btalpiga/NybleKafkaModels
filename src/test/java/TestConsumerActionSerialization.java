import com.google.gson.Gson;
import com.nyble.topics.TopicObjectsFactory;
import com.nyble.topics.consumerActions.ConsumerActionsValue;
import junit.framework.TestCase;

public class TestConsumerActionSerialization extends TestCase {



    public void test_serializeEmpty(){
        final String actionStringRep = "";
        ConsumerActionsValue cav = (ConsumerActionsValue) TopicObjectsFactory.fromJson(actionStringRep, ConsumerActionsValue.class);
        assertNull(cav);
    }

    public void test_serializeNull(){
        final String actionStringRep = null;
        ConsumerActionsValue cav = (ConsumerActionsValue) TopicObjectsFactory.fromJson(actionStringRep, ConsumerActionsValue.class);

        assertNull(cav);
    }

    public void test_serializeOnlyOneField(){
        final String actionStringRep = "{\"id\": 10}";
        ConsumerActionsValue cav = (ConsumerActionsValue) TopicObjectsFactory.fromJson(actionStringRep, ConsumerActionsValue.class);

        assertNotNull(cav);
        assertNull(cav.getExternalSystemDate());
        assertNull(cav.getLocalSystemDate());
        assertNull(cav.getPayloadJson());
        assertEquals("10", cav.getId());
        assertNull(cav.getActionId());
        assertNull(cav.getSystemId());
        assertNull(cav.getConsumerId());
    }

    public void test_serializeOnlyOneField_2(){
        final String actionStringRep = "{\"id\": \"10\"}";
        ConsumerActionsValue cav = (ConsumerActionsValue) TopicObjectsFactory.fromJson(actionStringRep, ConsumerActionsValue.class);

        assertNotNull(cav);
        assertNull(cav.getExternalSystemDate());
        assertNull(cav.getLocalSystemDate());
        assertNull(cav.getPayloadJson());
        assertEquals("10", cav.getId());
        assertNull(cav.getActionId());
        assertNull(cav.getSystemId());
        assertNull(cav.getConsumerId());
    }

    public void test_printSimpleConsumerAction(){
        ConsumerActionsValue.ConsumerActionsPayload payload = new ConsumerActionsValue.
                ConsumerActionsPayload("5201","5","aaa", "bbb", "ccc", null,
                null, null, null);
        ConsumerActionsValue cv = new ConsumerActionsValue("3000","187852", "1", payload, "123", "123");
        System.out.println(cv.toJson());
    }

    public void test_serializeNormal(){
        final String actionStringRep = "{\"id\":658221420,\"systemId\":1,\"consumerId\":12063792,\"actionId\":3000,\"payloadJson\":\"{\\\"posId\\\": null, \\\"value\\\": {\\\"sku_bought\\\":\\\"SBRCOLGD\\\", \\\"opt_in\\\": true, \\\"opt_in_sms\\\": true, \\\"ba_signature\\\": \\\"data:image/png;base64,iVBORw0KGgo\\\", \\\"one2one_contact_id\\\": \\\"28874\\\", \\\"one2one_campaign_id\\\": \\\"566\\\", \\\"one2one_contact_date\\\": \\\"2020-10-21 13:17:37\\\", \\\"opt_in_postaladdress\\\": true, \\\"one2one_campaign_name\\\": \\\"CCC GFB 2020\\\", \\\"one2one_campaign_type\\\": \\\"Teren\\\", \\\"opt_in_sms_validation\\\": false, \\\"one2one_contact_crm_id\\\": \\\"12063792\\\", \\\"opt_in_market_analysis\\\": true, \\\"opt_in_email_validation\\\": true, \\\"one2one_campaign_channel\\\": \\\"RTL\\\", \\\"one2one_campaign_hr_name\\\": \\\"566 Multibrand retail val 6\\\", \\\"one2one_campaign_brand_id\\\": \\\"3\\\", \\\"one2one_campaign_brand_name\\\": \\\"Winston & Sobranie\\\"}, \\\"chanId\\\": \\\"2\\\", \\\"userId\\\": \\\"0\\\", \\\"prizeId\\\": null, \\\"valGain\\\": null, \\\"valSpend\\\": null, \\\"externalId\\\": null, \\\"touchpointId\\\": null, \\\"subcampaignId\\\": \\\"5621\\\"}\",\"externalSystemDate\":\"1603275457000\",\"localSystemDate\":\"1603275481335\"}";
        ConsumerActionsValue cav = (ConsumerActionsValue) TopicObjectsFactory.fromJson(actionStringRep, ConsumerActionsValue.class);

        assertNotNull(cav);
        assertNotNull(cav.getExternalSystemDate());
        assertNotNull(cav.getLocalSystemDate());
        assertNotNull(cav.getPayloadJson());
        assertEquals("658221420", cav.getId());
        assertEquals("3000", cav.getActionId());
        assertEquals("1", cav.getSystemId());
        assertEquals("12063792", cav.getConsumerId());

        ConsumerActionsValue.ConsumerActionsPayload payload = cav.getPayloadJson();
        assertTrue(Integer.parseInt(payload.subcampaignId) != 0);
        assertEquals(payload.getRaw(), "{\"posId\": null, \"value\": {\"sku_bought\":\"SBRCOLGD\", \"opt_in\": true, \"opt_in_sms\": true, \"ba_signature\": \"data:image/png;base64,iVBORw0KGgo\", \"one2one_contact_id\": \"28874\", \"one2one_campaign_id\": \"566\", " +
                "\"one2one_contact_date\": \"2020-10-21 13:17:37\", \"opt_in_postaladdress\": true, " +
                "\"one2one_campaign_name\": \"CCC GFB 2020\", \"one2one_campaign_type\": \"Teren\", \"opt_in_sms_validation\": false, " +
                "\"one2one_contact_crm_id\": \"12063792\", \"opt_in_market_analysis\": true, \"opt_in_email_validation\": true, " +
                "\"one2one_campaign_channel\": \"RTL\", \"one2one_campaign_hr_name\": \"566 Multibrand retail val 6\", " +
                "\"one2one_campaign_brand_id\": \"3\", \"one2one_campaign_brand_name\": \"Winston & Sobranie\"}, " +
                "\"chanId\": \"2\", \"userId\": \"0\", \"prizeId\": null, \"valGain\": null, \"valSpend\": null, \"externalId\": null, " +
                "\"touchpointId\": null, \"subcampaignId\": \"5621\"}");

        ConsumerActionsValue.ConsumerActionsPayload.Value value = payload.getValue();
        assertNull(value.new_value);
        assertEquals("SBRCOLGD", value.sku_bought);
    }

}

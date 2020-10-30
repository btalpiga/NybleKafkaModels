import com.nyble.models.consumer.Consumer;
import com.nyble.topics.consumer.ChangedProperty;
import com.nyble.topics.consumer.ConsumerValue;
import junit.framework.TestCase;

public class TestConsumerSerialization extends TestCase {


    public void test_normalValue(){
        final String jsonRep = "{\"consumer\":{\"systemId\":{\"value\":\"1\",\"lut\":\"1601240400000\"},\"affinity_127\":" +
                "{\"value\":\"0\",\"lut\":\"1601240400000\"},\"affinity_138\":{\"value\":\"0\",\"lut\":\"1601240400000\"}," +
                "\"consumerId\":{\"value\":\"8464397\",\"lut\":\"1601240400000\"},\"affinity_125\":" +
                "{\"value\":\"0\",\"lut\":\"1601240400000\"},\"affinity_117\":{\"value\":\"0\",\"lut\":\"1601240400000\"}}," +
                "\"changedProperty\":{\"propertyName\":\"fullName\"}}";
        final ConsumerValue cv = ConsumerValue.fromJson(jsonRep);

        final Consumer c = cv.getConsumer();
        final ChangedProperty cp = cv.getChangedProperty();

        assertEquals(c.getValue("systemId"), "1");
        assertEquals(c.getValue("affinity_127"), "0");
        assertEquals(c.getValue("affinity_138"), "0");
        assertEquals(c.getValue("consumerId"), "8464397");
        assertEquals(c.getValue("affinity_125"), "0");
        assertNull(c.getValue("asadasdasdsadas"));

        assertEquals(c.getTimestamp("systemId"), "1601240400000");
        assertNull(c.getTimestamp("asadasdasdsadas"));

        assertEquals(cp.getPropertyName(), "fullName");
        assertNull(cp.getOldValue());
        assertNull(cp.getNewValue());
    }
}

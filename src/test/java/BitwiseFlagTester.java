import com.nyble.models.consumer.CAttribute;
import com.nyble.models.consumer.Consumer;
import com.nyble.models.consumer.ConsumerFlag;
import junit.framework.TestCase;


public class BitwiseFlagTester extends TestCase {

    public void test_bitOperations(){
        Consumer c = new Consumer();
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));

        c.setFlag(ConsumerFlag.IS_EMAIL_VALID);
        assertTrue(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));
        c.unsetFlag(ConsumerFlag.IS_EMAIL_VALID);
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));

        c.setFlag(ConsumerFlag.IS_PHONE_VALID);
        assertTrue(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));
        c.unsetFlag(ConsumerFlag.IS_PHONE_VALID);
        assertFalse(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));

        c.setFlag(ConsumerFlag.OPT_IN_EMAIL);
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_EMAIL));

        c.setFlag(ConsumerFlag.OPT_IN_EMAIL);
        c.setFlag(ConsumerFlag.OPT_IN_SMS);
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_SMS));
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_EMAIL));
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));
        assertFalse(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));
    }

    public void test_bitOperationsEmptyValue(){
        Consumer c = new Consumer();
        c.setProperty("flags", new CAttribute("", ""));
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));

        c.setFlag(ConsumerFlag.IS_EMAIL_VALID);
        assertTrue(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));
        c.unsetFlag(ConsumerFlag.IS_EMAIL_VALID);
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));

        c.setFlag(ConsumerFlag.IS_PHONE_VALID);
        assertTrue(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));
        c.unsetFlag(ConsumerFlag.IS_PHONE_VALID);
        assertFalse(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));

        c.setFlag(ConsumerFlag.OPT_IN_EMAIL);
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_EMAIL));

        c.setFlag(ConsumerFlag.OPT_IN_EMAIL);
        c.setFlag(ConsumerFlag.OPT_IN_SMS);
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_SMS));
        assertTrue(c.isFlagSet(ConsumerFlag.OPT_IN_EMAIL));
        assertFalse(c.isFlagSet(ConsumerFlag.IS_EMAIL_VALID));
        assertFalse(c.isFlagSet(ConsumerFlag.IS_PHONE_VALID));
    }
}

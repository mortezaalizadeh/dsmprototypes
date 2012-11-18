package dsm.common;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for Common project.
 */
public class AppTest extends Object {

    /**
     * DSMManifest unique identifier to be used during test.
     */
    public static final String DSM_UNIQUE_IDENTIFIER =
            "2a605f21-0abf-402c-83e1-0ac95bad9bac";

    /**
     * DSMManifest friendly name to be used during test.
     */
    public static final String DSM_FRIDNELY_NAME =
            "Test Object";

    /**
     * IllegalArgumentException expected exception message.
     */
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE =
            "Expected an IllegalArgumentException.";

    /**
     * Positive testing to test DsmFriendlyName constructor.
     */
    @Test
    @Category(dsm.common.DsmManifest.class)
    public final void testPositiveDsmManifestConstructor01() {
        final DsmManifest dsmManifest =
                new DsmManifest(AppTest.DSM_UNIQUE_IDENTIFIER,
                                AppTest.DSM_FRIDNELY_NAME);

        if (dsmManifest.getDsmUniqueIdentifier().compareTo(AppTest.DSM_UNIQUE_IDENTIFIER) != 0) {
            Assert.fail("DsmUniqueIdentifier did not match.");
        }

        if (dsmManifest.getDsmFriendlyName().compareTo(AppTest.DSM_FRIDNELY_NAME) != 0) {
            Assert.fail("DsmFriendlyName did not match.");
        }
    }

    /**
     * Positive testing to test DsmUniqueIdentifier get and set methods.
     */
    @Test
    @Category(dsm.common.DsmManifest.class)
    public final void testPositiveDsmUniqueIdentifierGetAndSetMethods01() {
        final DsmManifest dsmManifest =
                new DsmManifest();

        dsmManifest.setDsmUniqueIdentifier(AppTest.DSM_UNIQUE_IDENTIFIER);

        if (dsmManifest.getDsmUniqueIdentifier().compareTo(AppTest.DSM_UNIQUE_IDENTIFIER) != 0) {
            Assert.fail("DsmUniqueIdentifier did not match.");
        }
    }

    /**
     * Negative testing to test DsmFriendlyName constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmUniqueIdentifierGetAndSetMethods01() {
        (new DsmManifest()).setDsmUniqueIdentifier(null);

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmUniqueIdentifierGetAndSetMethods02() {
        (new DsmManifest()).setDsmUniqueIdentifier("");

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmUniqueIdentifierGetAndSetMethods03() {
        (new DsmManifest()).setDsmUniqueIdentifier(" ");

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Positive testing to test DsmFriendlyName get and set methods.
     */
    @Test
    @Category(dsm.common.DsmManifest.class)
    public final void testPositiveDsmFriendlyNameGetAndSetMethods01() {
        final DsmManifest dsmManifest =
                new DsmManifest();

        dsmManifest.setDsmFriendlyName(AppTest.DSM_FRIDNELY_NAME);

        if (dsmManifest.getDsmFriendlyName().compareTo(AppTest.DSM_FRIDNELY_NAME) != 0) {
            Assert.fail("DsmFriendlyName did not match.");
        }
    }

    /**
     * Negative testing to test DsmFriendlyName get and set methods.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmFriendlyNameGetAndSetMethods01() {
        (new DsmManifest()).setDsmFriendlyName(null);

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName get and set methods.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmFriendlyNameGetAndSetMethods02() {
        (new DsmManifest()).setDsmFriendlyName("");

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName get and set methods.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmFriendlyNameGetAndSetMethods03() {
        (new DsmManifest()).setDsmFriendlyName(" ");

        Assert.fail(AppTest.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }
}

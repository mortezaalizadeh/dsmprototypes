package dsm.common;

import dsm.common.test.AbstractAppTestBase;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for common project.
 */
public class AppTest extends AbstractAppTestBase {
    /**
     * Positive testing to test DsmFriendlyName constructor.
     */
    @Test
    @Category(dsm.common.DsmManifest.class)
    public final void testPositiveDsmManifestConstructor01() {
        final DsmManifest dsmManifest =
                new DsmManifest(AbstractAppTestBase.DSM_UNIQUE_IDENTIFIER,
                                AbstractAppTestBase.DSM_FRIDNELY_NAME);

        if (dsmManifest.getDsmUniqueIdentifier().compareTo(AbstractAppTestBase.DSM_UNIQUE_IDENTIFIER) != 0) {
            Assert.fail("DsmUniqueIdentifier did not match.");
        }

        if (dsmManifest.getDsmFriendlyName().compareTo(AbstractAppTestBase.DSM_FRIDNELY_NAME) != 0) {
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

        dsmManifest.setDsmUniqueIdentifier(AbstractAppTestBase.DSM_UNIQUE_IDENTIFIER);

        if (dsmManifest.getDsmUniqueIdentifier().compareTo(AbstractAppTestBase.DSM_UNIQUE_IDENTIFIER) != 0) {
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

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmUniqueIdentifierGetAndSetMethods02() {
        (new DsmManifest()).setDsmUniqueIdentifier("");

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmUniqueIdentifierGetAndSetMethods03() {
        (new DsmManifest()).setDsmUniqueIdentifier(" ");

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Positive testing to test DsmFriendlyName get and set methods.
     */
    @Test
    @Category(dsm.common.DsmManifest.class)
    public final void testPositiveDsmFriendlyNameGetAndSetMethods01() {
        final DsmManifest dsmManifest =
                new DsmManifest();

        dsmManifest.setDsmFriendlyName(AbstractAppTestBase.DSM_FRIDNELY_NAME);

        if (dsmManifest.getDsmFriendlyName().compareTo(AbstractAppTestBase.DSM_FRIDNELY_NAME) != 0) {
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

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName get and set methods.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmFriendlyNameGetAndSetMethods02() {
        (new DsmManifest()).setDsmFriendlyName("");

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }

    /**
     * Negative testing to test DsmFriendlyName get and set methods.
     */
    @Test(expected = IllegalArgumentException.class)
    @Category(dsm.common.DsmManifest.class)
    public final void testNegativeDsmFriendlyNameGetAndSetMethods03() {
        (new DsmManifest()).setDsmFriendlyName(" ");

        Assert.fail(AbstractAppTestBase.ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED_MESSAGE);
    }
}

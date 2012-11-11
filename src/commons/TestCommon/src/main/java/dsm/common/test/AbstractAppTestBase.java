/**
 * @author Morteza Alizadeh
 */
package dsm.common.test;

/**
 * Base class for all Dsm test classes.
 *
 * This class must be inherited by all Dsm classes.
 *
 * @version 0.1, November 11, 2012
 * @author Morteza Alizadeh
 */
public abstract class AbstractAppTestBase extends Object {
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
     * AbstractAppTestBase Constructor.
     */
    public AbstractAppTestBase() {
        super();
    }
}

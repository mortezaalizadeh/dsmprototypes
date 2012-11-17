package dsm.action.common;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for DsmCommon package.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case.
     *
     * @param testName name of the test case
     */
    public AppTest(final String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigorous Test.
     */
    public final void testApp() {
        assertTrue(true);
    }
}
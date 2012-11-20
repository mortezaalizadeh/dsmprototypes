/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.dsmdaemon;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.basicimplementations.BasicGuiceInjectorModule;
import dsm.common.argument.ArgumentContainer;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for DsmDaemon project.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class AppTest extends Object {

    /**
     * Positive testing to test BasicActionStartupInfo.
     */
    @Test
    @Category(dsm.daemon.dsmdaemon.DsmDaemon.class)
    public final void testPositiveBasicActionStartupInfo01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ArgumentContainer initializationParams = injector.getInstance(
                ArgumentContainer.class);

        final DsmDaemon dsmDaemon = new DsmDaemon();

        dsmDaemon.init(initializationParams);
        Assert.assertTrue(dsmDaemon.isInited());

        dsmDaemon.shutdown();
        Assert.assertFalse(dsmDaemon.isInited());
    }
}

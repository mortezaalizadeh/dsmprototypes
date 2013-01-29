/**
 * @author Morteza Alizadeh
 */
package dsm.actionmanager;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.basicimplementations.BasicGuiceInjectorModule;
import dsm.common.argument.ArgumentContainer;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for SimpleActionManager project.
 *
 * @version 0.1, November 20, 2012
 * @author Morteza Alizadeh
 */
public class AppTest extends Object {

    /**
     * Positive testing to test SimpleActionManager.
     */
    @Test
    @Category(dsm.actionmanager.SimpleActionManager.class)
    public final void testPositiveSimpleActionManager01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ArgumentContainer initializationParams = injector.getInstance(
                ArgumentContainer.class);

        final SimpleActionManager simpleActionManager = new SimpleActionManager();

        simpleActionManager.init(initializationParams);
        Assert.assertTrue(simpleActionManager.isInited());

        simpleActionManager.shutdown();
        Assert.assertFalse(simpleActionManager.isInited());
    }
}

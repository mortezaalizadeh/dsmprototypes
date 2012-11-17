package dsm.basic.implementations;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.common.argument.ArgumentContainer;
import dsm.common.test.AbstractAppTestBase;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for Basic Implementations project.
 */
public class AppTest extends AbstractAppTestBase {

    /**
     * Positive testing to test BasicArgumentContainer.
     */
    @Test
    @Category(dsm.basic.implementations.argument.BasicArgumentContainer.class)
    public final void testPositiveBasicArgumentContainer01() {
        final Injector injector = Guice.createInjector(new BasicGuiceInjectorModule());
        final ArgumentContainer argumentContainer = injector.getInstance(ArgumentContainer.class);

        final Integer firstArgument = Integer.valueOf(10);
        final Double secondArgument = Double.valueOf(20.36);
        final Integer thirdArgument = Integer.valueOf(30);

        argumentContainer.setArgument("Arg01", firstArgument);
        argumentContainer.setArgument("Arg02", secondArgument);
        argumentContainer.setArgument("Arg03", thirdArgument);

        final Integer thirdRetArgument = (Integer) argumentContainer.getArgument("Arg03");
        final Integer firstRetArgument = (Integer) argumentContainer.getArgument("Arg01");
        final Double secondRetArgument = (Double) argumentContainer.getArgument("Arg02");

        Assert.assertEquals(firstArgument, firstRetArgument);
        Assert.assertEquals(secondArgument, secondRetArgument);
        Assert.assertEquals(thirdArgument, thirdRetArgument);
    }
}

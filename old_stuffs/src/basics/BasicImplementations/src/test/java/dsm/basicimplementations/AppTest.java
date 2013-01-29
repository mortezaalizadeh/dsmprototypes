/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.argument.ArgumentContainer;
import dsm.common.configuration.ConfigurationParser;
import dsm.daemon.common.DaemonStartupInfo;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for BasicImplementations project.
 *
 * @version 0.1, November 19, 2012
 * @author Morteza Alizadeh
 */
public class AppTest extends Object {

    /**
     * Test Unique Identifier to be used during test.
     */
    private static final String TEST_UNIQUE_IDENTIFIER = "Unique Identifier";

    /**
     * Test Library to be used during test.
     */
    private static final String TEST_LIBRARY = "Library";

    /**
     * Test PackageName to be used during test.
     */
    private static final String TEST_PACKAGE_NAME = "PackageName";

    /**
     * Test ClassName to be used during test.
     */
    private static final String TEST_CLASS_NAME = "ClassName";

    /**
     * Test ConfigurationFileFullPath to be used during test.
     */
    private static final String TEST_CONFIGURATION_FILE_PATH = "ConfigurationFileFullPath";

    /**
     * Positive testing to test BasicActionStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.action.common.BasicActionStartupInfo.class)
    public final void testPositiveBasicActionStartupInfo01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ActionStartupInfo actionStartupInfo = injector.getInstance(
                ActionStartupInfo.class);

        actionStartupInfo.setUniqueIdentifier(AppTest.TEST_UNIQUE_IDENTIFIER);
        actionStartupInfo.setLibrary(AppTest.TEST_LIBRARY);
        actionStartupInfo.setPackageName(AppTest.TEST_PACKAGE_NAME);
        actionStartupInfo.setClassName(AppTest.TEST_CLASS_NAME);
        actionStartupInfo.setConfigurationFileFullPath(AppTest.TEST_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(actionStartupInfo.getUniqueIdentifier().compareTo(
                AppTest.TEST_UNIQUE_IDENTIFIER),
                0);
        Assert.assertEquals(actionStartupInfo.getLibrary().compareTo(
                AppTest.TEST_LIBRARY),
                0);
        Assert.assertEquals(actionStartupInfo.getPackageName().compareTo(
                AppTest.TEST_PACKAGE_NAME),
                0);
        Assert.assertEquals(actionStartupInfo.getClassName().compareTo(
                AppTest.TEST_CLASS_NAME),
                0);
        Assert.assertEquals(actionStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.TEST_CONFIGURATION_FILE_PATH),
                0);
    }

    /**
     * Positive testing to test BasicActionManagerStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.action.manager.common.BasicActionManagerStartupInfo.class)
    public final void testPositiveBasicActionManagerStartupInfo01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ActionManagerStartupInfo actionManagerStartupInfo = injector.getInstance(
                ActionManagerStartupInfo.class);

        actionManagerStartupInfo.setUniqueIdentifier(AppTest.TEST_UNIQUE_IDENTIFIER);
        actionManagerStartupInfo.setLibrary(AppTest.TEST_LIBRARY);
        actionManagerStartupInfo.setPackageName(AppTest.TEST_PACKAGE_NAME);
        actionManagerStartupInfo.setClassName(AppTest.TEST_CLASS_NAME);
        actionManagerStartupInfo.setConfigurationFileFullPath(AppTest.TEST_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(actionManagerStartupInfo.getUniqueIdentifier().compareTo(
                AppTest.TEST_UNIQUE_IDENTIFIER),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getLibrary().compareTo(
                AppTest.TEST_LIBRARY),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getPackageName().compareTo(
                AppTest.TEST_PACKAGE_NAME),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getClassName().compareTo(
                AppTest.TEST_CLASS_NAME),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.TEST_CONFIGURATION_FILE_PATH),
                0);
    }

    /**
     * Positive testing to test BasicArgumentContainer.
     */
    @Test
    @Category(dsm.basicimplementations.common.argument.BasicArgumentContainer.class)
    public final void testPositiveBasicArgumentContainer01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ArgumentContainer argumentContainer = injector.getInstance(
                ArgumentContainer.class);

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

    /**
     * Positive testing to test BasicDaemonStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.daemon.common.BasicDaemonStartupInfo.class)
    public final void testPositiveBasicDaemonStartupInfo01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final DaemonStartupInfo daemonStartupInfo = injector.getInstance(
                DaemonStartupInfo.class);

        daemonStartupInfo.setUniqueIdentifier(AppTest.TEST_UNIQUE_IDENTIFIER);
        daemonStartupInfo.setLibrary(AppTest.TEST_LIBRARY);
        daemonStartupInfo.setPackageName(AppTest.TEST_PACKAGE_NAME);
        daemonStartupInfo.setClassName(AppTest.TEST_CLASS_NAME);
        daemonStartupInfo.setConfigurationFileFullPath(AppTest.TEST_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(daemonStartupInfo.getUniqueIdentifier().compareTo(
                AppTest.TEST_UNIQUE_IDENTIFIER),
                0);
        Assert.assertEquals(daemonStartupInfo.getLibrary().compareTo(
                AppTest.TEST_LIBRARY),
                0);
        Assert.assertEquals(daemonStartupInfo.getPackageName().compareTo(
                AppTest.TEST_PACKAGE_NAME),
                0);
        Assert.assertEquals(daemonStartupInfo.getClassName().compareTo(
                AppTest.TEST_CLASS_NAME),
                0);
        Assert.assertEquals(daemonStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.TEST_CONFIGURATION_FILE_PATH),
                0);
    }

    /**
     * Positive testing to test BasicConfigurationParser.
     */
    @Test
    @Category(dsm.basicimplementations.common.configuration.BasicConfigurationParser.class)
    public final void testPositiveBasicConfigurationParser01() {
        final Injector injector = Guice.createInjector(
                new BasicGuiceInjectorModule());
        final ConfigurationParser configurationParser = injector.getInstance(
                ConfigurationParser.class);

        configurationParser.loadConfigurationsFromFile("configurations/configuration.xml");
    }
}

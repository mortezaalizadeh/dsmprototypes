package dsm.basicimplementations;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.common.ActionStartupInfo;
import dsm.common.argument.ArgumentContainer;
import dsm.daemon.common.DaemonStartupInfo;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for Basic Implementations project.
 */
public class AppTest extends Object {

    /**
     * Daemon Startup Info Name to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_NAME =
            "This is a test action startup info Name.";

    /**
     * Daemon Startup Info Library to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_LIBRARY =
            "This is a test action startup info Library.";

    /**
     * Daemon Startup Info PackageName to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_PACKAGE_NAME =
            "This is a test action startup info PackageName.";

    /**
     * Daemon Startup Info ClassName to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_CLASS_NAME =
            "This is a test action startup info ClassName.";

    /**
     * Daemon Startup Info ConfigurationFileFullPath to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_CONFIGURATION_FILE_PATH =
            "This is a test action startup info ConfigurationFileFullPath.";

    /**
     * Daemon Startup Info Name to be used during test.
     */
    private static final String DAEMON_STARTUP_INFO_NAME =
            "This is a test daemon startup info Name.";

    /**
     * Daemon Startup Info Library to be used during test.
     */
    private static final String DAEMON_STARTUP_INFO_LIBRARY =
            "This is a test daemon startup info Library.";

    /**
     * Daemon Startup Info PackageName to be used during test.
     */
    private static final String DAEMON_STARTUP_INFO_PACKAGE_NAME =
            "This is a test daemon startup info PackageName.";

    /**
     * Daemon Startup Info ClassName to be used during test.
     */
    private static final String DAEMON_STARTUP_INFO_CLASS_NAME =
            "This is a test daemon startup info ClassName.";

    /**
     * Daemon Startup Info ConfigurationFileFullPath to be used during test.
     */
    private static final String DAEMON_STARTUP_INFO_CONFIGURATION_FILE_PATH =
            "This is a test daemon startup info ConfigurationFileFullPath.";

    /**
     * Positive testing to test BasicActionStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.action.common.BasicActionStartupInfo.class)
    public final void testPositiveBasicActionStartupInfo01() {
        final Injector injector = Guice.createInjector(new BasicGuiceInjectorModule());
        final ActionStartupInfo actionStartupInfo = injector.getInstance(ActionStartupInfo.class);

        actionStartupInfo.setName(AppTest.ACTION_STARTUP_INFO_NAME);
        actionStartupInfo.setLibrary(AppTest.ACTION_STARTUP_INFO_LIBRARY);
        actionStartupInfo.setPackageName(AppTest.ACTION_STARTUP_INFO_PACKAGE_NAME);
        actionStartupInfo.setClassName(AppTest.ACTION_STARTUP_INFO_CLASS_NAME);
        actionStartupInfo.setConfigurationFileFullPath(AppTest.ACTION_STARTUP_INFO_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(actionStartupInfo.getName().compareTo(
                AppTest.ACTION_STARTUP_INFO_NAME),
                0);
        Assert.assertEquals(actionStartupInfo.getLibrary().compareTo(
                AppTest.ACTION_STARTUP_INFO_LIBRARY),
                0);
        Assert.assertEquals(actionStartupInfo.getPackageName().compareTo(
                AppTest.ACTION_STARTUP_INFO_PACKAGE_NAME),
                0);
        Assert.assertEquals(actionStartupInfo.getClassName().compareTo(
                AppTest.ACTION_STARTUP_INFO_CLASS_NAME),
                0);
        Assert.assertEquals(actionStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.ACTION_STARTUP_INFO_CONFIGURATION_FILE_PATH),
                0);
    }

    /**
     * Positive testing to test BasicArgumentContainer.
     */
    @Test
    @Category(dsm.basicimplementations.common.argument.BasicArgumentContainer.class)
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

    /**
     * Positive testing to test BasicDaemonStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.daemon.common.BasicDaemonStartupInfo.class)
    public final void testPositiveBasicDaemonStartupInfo01() {
        final Injector injector = Guice.createInjector(new BasicGuiceInjectorModule());
        final DaemonStartupInfo daemonStartupInfo = injector.getInstance(DaemonStartupInfo.class);

        daemonStartupInfo.setName(AppTest.DAEMON_STARTUP_INFO_NAME);
        daemonStartupInfo.setLibrary(AppTest.DAEMON_STARTUP_INFO_LIBRARY);
        daemonStartupInfo.setPackageName(AppTest.DAEMON_STARTUP_INFO_PACKAGE_NAME);
        daemonStartupInfo.setClassName(AppTest.DAEMON_STARTUP_INFO_CLASS_NAME);
        daemonStartupInfo.setConfigurationFileFullPath(AppTest.DAEMON_STARTUP_INFO_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(daemonStartupInfo.getName().compareTo(
                AppTest.DAEMON_STARTUP_INFO_NAME),
                0);
        Assert.assertEquals(daemonStartupInfo.getLibrary().compareTo(
                AppTest.DAEMON_STARTUP_INFO_LIBRARY),
                0);
        Assert.assertEquals(daemonStartupInfo.getPackageName().compareTo(
                AppTest.DAEMON_STARTUP_INFO_PACKAGE_NAME),
                0);
        Assert.assertEquals(daemonStartupInfo.getClassName().compareTo(
                AppTest.DAEMON_STARTUP_INFO_CLASS_NAME),
                0);
        Assert.assertEquals(daemonStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.DAEMON_STARTUP_INFO_CONFIGURATION_FILE_PATH),
                0);
    }
}

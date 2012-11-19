/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.argument.ArgumentContainer;
import dsm.daemon.common.DaemonStartupInfo;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Unit test for Basic Implementations project.
 *
 * @version 0.1, November 19, 2012
 * @author Morteza Alizadeh
 */
public class AppTest extends Object {

    /**
     * Action Startup Info Name to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_NAME =
            "This is a test action startup info Name.";

    /**
     * Action Startup Info Library to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_LIBRARY =
            "This is a test action startup info Library.";

    /**
     * Action Startup Info PackageName to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_PACKAGE_NAME =
            "This is a test action startup info PackageName.";

    /**
     * Action Startup Info ClassName to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_CLASS_NAME =
            "This is a test action startup info ClassName.";

    /**
     * Action Startup Info ConfigurationFileFullPath to be used during test.
     */
    private static final String ACTION_STARTUP_INFO_CONFIGURATION_FILE_PATH =
            "This is a test action startup info ConfigurationFileFullPath.";

    /**
     * Action Manager Startup Info Name to be used during test.
     */
    private static final String ACTION_MANAGER_STARTUP_INFO_NAME =
            "This is a test action manager startup info Name.";

    /**
     * Action Manager Startup Info Library to be used during test.
     */
    private static final String ACTION_MANAGER_STARTUP_INFO_LIBRARY =
            "This is a test action manager startup info Library.";

    /**
     * Action Manager Startup Info PackageName to be used during test.
     */
    private static final String ACTION_MANAGER_STARTUP_INFO_PACKAGE_NAME =
            "This is a test action manager startup info PackageName.";

    /**
     * Action Manager Startup Info ClassName to be used during test.
     */
    private static final String ACTION_MANAGER_STARTUP_INFO_CLASS_NAME =
            "This is a test action manager startup info ClassName.";

    /**
     * Action Manager Startup Info ConfigurationFileFullPath to be used during test.
     */
    private static final String ACTION_MANAGER_STARTUP_INFO_CONFIGURATION_FILE_PATH =
            "This is a test action manager startup info ConfigurationFileFullPath.";

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

        actionStartupInfo.setName(
                AppTest.ACTION_STARTUP_INFO_NAME);
        actionStartupInfo.setLibrary(
                AppTest.ACTION_STARTUP_INFO_LIBRARY);
        actionStartupInfo.setPackageName(
                AppTest.ACTION_STARTUP_INFO_PACKAGE_NAME);
        actionStartupInfo.setClassName(
                AppTest.ACTION_STARTUP_INFO_CLASS_NAME);
        actionStartupInfo.setConfigurationFileFullPath(
                AppTest.ACTION_STARTUP_INFO_CONFIGURATION_FILE_PATH);

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
     * Positive testing to test BasicActionManagerStartupInfo.
     */
    @Test
    @Category(dsm.basicimplementations.action.manager.common.BasicActionManagerStartupInfo.class)
    public final void testPositiveBasicActionManagerStartupInfo01() {
        final Injector injector = Guice.createInjector(new BasicGuiceInjectorModule());
        final ActionManagerStartupInfo actionManagerStartupInfo = injector.getInstance(ActionManagerStartupInfo.class);

        actionManagerStartupInfo.setName(
                AppTest.ACTION_MANAGER_STARTUP_INFO_NAME);
        actionManagerStartupInfo.setLibrary(
                AppTest.ACTION_MANAGER_STARTUP_INFO_LIBRARY);
        actionManagerStartupInfo.setPackageName(
                AppTest.ACTION_MANAGER_STARTUP_INFO_PACKAGE_NAME);
        actionManagerStartupInfo.setClassName(
                AppTest.ACTION_MANAGER_STARTUP_INFO_CLASS_NAME);
        actionManagerStartupInfo.setConfigurationFileFullPath(
                AppTest.ACTION_MANAGER_STARTUP_INFO_CONFIGURATION_FILE_PATH);

        Assert.assertEquals(actionManagerStartupInfo.getName().compareTo(
                AppTest.ACTION_MANAGER_STARTUP_INFO_NAME),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getLibrary().compareTo(
                AppTest.ACTION_MANAGER_STARTUP_INFO_LIBRARY),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getPackageName().compareTo(
                AppTest.ACTION_MANAGER_STARTUP_INFO_PACKAGE_NAME),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getClassName().compareTo(
                AppTest.ACTION_MANAGER_STARTUP_INFO_CLASS_NAME),
                0);
        Assert.assertEquals(actionManagerStartupInfo.getConfigurationFileFullPath().compareTo(
                AppTest.ACTION_MANAGER_STARTUP_INFO_CONFIGURATION_FILE_PATH),
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

        daemonStartupInfo.setName(
                AppTest.DAEMON_STARTUP_INFO_NAME);
        daemonStartupInfo.setLibrary(
                AppTest.DAEMON_STARTUP_INFO_LIBRARY);
        daemonStartupInfo.setPackageName(
                AppTest.DAEMON_STARTUP_INFO_PACKAGE_NAME);
        daemonStartupInfo.setClassName(
                AppTest.DAEMON_STARTUP_INFO_CLASS_NAME);
        daemonStartupInfo.setConfigurationFileFullPath(
                AppTest.DAEMON_STARTUP_INFO_CONFIGURATION_FILE_PATH);

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

/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.daemon.common;

import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;

/**
 * BasicDaemonStartupInfo is a basic implementation for DaemonStartupInfo.
 *
 * @version 0.1, November 17, 2012
 * @author Morteza Alizadeh
 */
public class BasicDaemonStartupInfo extends DsmManifest implements DaemonStartupInfo {

    /**
     * Daemon unique identifier.
     */
    private String uniqueIdentifier;

    /**
     * Daemon library.
     */
    private String library;

    /**
     * Daemon package name.
     */
    private String packageName;

    /**
     * Daemon class name.
     */
    private String className;

    /**
     * Daemon configuration file full path.
     */
    private String configurationFileFullPath;

    /**
     * BasicDaemonStartupInfo constructor.
     */
    public BasicDaemonStartupInfo() {
        super("634b7eab-c77f-494b-b10a-a646288ca16a", "Basic Daemon Startup Info");

        this.uniqueIdentifier = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
        this.configurationFileFullPath = "";
    }

    /**
     * Returns daemon unique identifier.
     *
     * @return Daemon unique identifier
     */
    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set daemon unique identifier.
     *
     * @param newUniqueIdentifier New daemon unique identifier
     */
    public void setUniqueIdentifier(final String newUniqueIdentifier) {
        this.uniqueIdentifier = newUniqueIdentifier;
    }

    /**
     * Returns daemon library.
     *
     * @return Daemon library
     */
    public String getLibrary() {
        return this.library;
    }

    /**
     * Set daemon library.
     *
     * @param newLibrary New daemon library
     */
    public void setLibrary(final String newLibrary) {
        this.library = newLibrary;
    }

    /**
     * Returns daemon package name.
     *
     * @return Daemon package name
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * Set daemon package name.
     *
     * @param newPackageName New daemon package name
     */
    public void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
    }

    /**
     * Returns daemon class name.
     *
     * @return Daemon class name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Set daemon class name.
     *
     * @param newClassName New daemon class name
     */
    public void setClassName(final String newClassName) {
        this.className = newClassName;
    }

    /**
     * Returns daemon configuration file full path.
     *
     * @return Daemon configuration file full path
     */
    public String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set daemon configuration file full path.
     *
     * @param newConfigurationFileFullPath New daemon configuration file full path
     */
    public void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

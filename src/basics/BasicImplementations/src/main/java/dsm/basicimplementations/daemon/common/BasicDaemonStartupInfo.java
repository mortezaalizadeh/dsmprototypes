/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.daemon.common;

import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;

/**
* BasicDaemonStartupInfo is a basic implementation as an DaemonStartupInfo.
*
* @version 0.1, November 17, 2012
  * @author Morteza Alizadeh
 */
public class BasicDaemonStartupInfo extends DsmManifest implements DaemonStartupInfo {

    /**
     * Daemon name.
     */
    private String name;

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
     * DaemonInfo constructor.
     */
    public BasicDaemonStartupInfo() {
        super("634b7eab-c77f-494b-b10a-a646288ca16a", "Basic Daemon Startup Info");

        this.name = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
        this.configurationFileFullPath = "";
    }

    /**
     * Returns daemon name.
     *
     * @return Daemon name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Set daemon name.
     *
     * @param newName New daemon name
     */
    public final void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns daemon library.
     *
     * @return Daemon library
     */
    public final String getLibrary() {
        return this.library;
    }

    /**
     * Set daemon library.
     *
     * @param newLibrary New daemon library
     */
    public final void setLibrary(final String newLibrary) {
        this.library = newLibrary;
    }

    /**
     * Returns daemon package name.
     *
     * @return Daemon package name
     */
    public final String getPackageName() {
        return this.packageName;
    }

    /**
     * Set daemon package name.
     *
     * @param newPackageName New daemon package name
     */
    public final void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
    }

    /**
     * Returns daemon class name.
     *
     * @return Daemon class name
     */
    public final String getClassName() {
        return this.className;
    }

    /**
     * Set daemon class name.
     *
     * @param newClassName New daemon class name
     */
    public final void setClassName(final String newClassName) {
        this.className = newClassName;
    }

    /**
     * Returns daemon configuration file full path.
     *
     * @return Daemon configuration file full path
     */
    public final String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set daemon configuration file full path.
     *
     * @param newConfigurationFileFullPath New daemon configuration file full path
     */
    public final void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

/**
 * @author Morteza Alizadeh
 */
package dsm.daemon.common;

import dsm.common.DsmManifest;

/**
* DaemonInfo class is an entity class represent a daemon.
* 
* @version 0.1, April 16, 2012
  * @author Morteza Alizadeh
 */
public class DaemonStartupInfo extends DsmManifest {

    /**
     * Daemon name
     */
    private String name;

    /**
     * Daemon library
     */
    private String library;

    /**
     * Daemon package name
     */
    private String packageName;

    /**
     * Daemon class name
     */
    private String className;

    /**
     * Daemon configuration file full path
     */
    private String configurationFileFullPath;

    /**
     * DaemonInfo constructor.
     */
    public DaemonStartupInfo() {
        super("634b7eab-c77f-494b-b10a-a646288ca16a", "Daemon Startup Info");
        
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
    public String getName() {
        return this.name;
    }

    /**
     * Set daemon name.
     * 
     * @param szName New daemon name to set
     */
    public void setName(String szName) {
        this.name = szName;
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
     * @param szLibrary New daemon library to set
     */
    public void setLibrary(String szLibrary) {
        this.library = szLibrary;
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
     * @param szPackageName New daemon package name to set
     */
    public void setPackageName(String szPackageName) {
        this.packageName = szPackageName;
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
     * @param szClassName New daemon class name to set
     */
    public void setClassName(String szClassName) {
        this.className = szClassName;
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
     * @param szConfigurationFileFullPath New daemon configuration file full path to set
     */
    public void setConfigurationFileFullPath(String szConfigurationFileFullPath) {
        this.configurationFileFullPath = szConfigurationFileFullPath;
    }
}

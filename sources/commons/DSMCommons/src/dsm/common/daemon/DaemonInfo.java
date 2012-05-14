/**
 * @author Morteza Alizadeh
 */
package dsm.common.daemon;

import dsm.common.DSMManifest;

/**
* DaemonInfo class is an entity class represent a daemon.
* 
* @version 0.1, April 16, 2012
  * @author Morteza Alizadeh
 */
public class DaemonInfo extends DSMManifest {

    /**
     * Daemon name
     */
    protected String name;

    /**
     * Daemon unique identifier
     */
    protected String uniqueIdentifier;

    /**
     * Daemon library
     */
    protected String library;

    /**
     * Daemon package name
     */
    protected String packageName;

    /**
     * Daemon class name
     */
    protected String className;

    /**
     * Daemon configuration file full path
     */
    protected String configurationFileFullPath;

    /**
     * DaemonInfo constructor.
     */
    public DaemonInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe1", "Daemon Info");
        
        name = "";
        uniqueIdentifier = "";
        library = "";
        packageName = "";
        className = "";
        configurationFileFullPath = "";
    }

    /**
     * Returns daemon unique identifier.
     * 
     * @return Daemon unique identifier
     */
    public String getName() {
        return name;
    }

    /**
     * Set daemon name.
     * 
     * @param szName New daemon name to set
     */
    public void setName(String szName) {
        name = szName;
    }

    /**
     * Returns daemon unique identifier.
     * 
     * @return Daemon unique identifier
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * Set daemon unique identifier.
     * 
     * @param szUniqueIdentifier New daemon unique identifier to set
     */
    public void setUniqueIdentifier(String szUniqueIdentifier) {
        uniqueIdentifier = szUniqueIdentifier;
    }

    /**
     * Returns daemon library.
     * 
     * @return Daemon library
     */
    public String getLibrary() {
        return library;
    }

    /**
     * Set daemon library.
     * 
     * @param szLibrary New daemon library to set
     */
    public void setLibrary(String szLibrary) {
        library = szLibrary;
    }

    /**
     * Returns daemon package name.
     * 
     * @return Daemon package name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Set daemon package name.
     * 
     * @param szPackageName New daemon package name to set
     */
    public void setPackageName(String szPackageName) {
        packageName = szPackageName;
    }

    /**
     * Returns daemon class name.
     * 
     * @return Daemon class name
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set daemon class name.
     * 
     * @param szClassName New daemon class name to set
     */
    public void setClassName(String szClassName) {
        className = szClassName;
    }

    /**
     * Returns daemon configuration file full path.
     * 
     * @return Daemon configuration file full path
     */
    public String getConfigurationFileFullPath() {
        return configurationFileFullPath;
    }

    /**
     * Set daemon configuration file full path.
     * 
     * @param szConfigurationFileFullPath New daemon configuration file full path to set
     */
    public void setConfigurationFileFullPath(String szConfigurationFileFullPath) {
        configurationFileFullPath = szConfigurationFileFullPath;
    }
}

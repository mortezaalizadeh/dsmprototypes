/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager.common;

import dsm.common.DSMManifest;

/**
* ActionManagerInfo class is an entity class represent a action manager startup
* info.
* 
* @version 0.1, May 20, 2012
  * @author Morteza Alizadeh
 */
public class ActionManagerStartupInfo extends DSMManifest {

    /**
     * Action manager name
     */
    private String name;

    /**
     * Action manager library
     */
    private String library;

    /**
     * Action manager package name
     */
    private String packageName;

    /**
     * Action manager class name
     */
    private String className;

    /**
     * Action manager configuration file full path
     */
    private String configurationFileFullPath;

    /**
     * ActionManagerInfo constructor.
     */
    public ActionManagerStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe3", "Action Manager Startup Info");
        
        this.name = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
        this.configurationFileFullPath = "";
    }

    /**
     * Returns action manager name.
     * 
     * @return Action manager name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set action manager name.
     * 
     * @param szName New action manager name to set
     */
    public void setName(String szName) {
        this.name = szName;
    }

    /**
     * Returns action manager library.
     * 
     * @return Action manager library
     */
    public String getLibrary() {
        return this.library;
    }

    /**
     * Set action manager library.
     * 
     * @param szLibrary New action manager library to set
     */
    public void setLibrary(String szLibrary) {
        this.library = szLibrary;
    }

    /**
     * Returns action manager package name.
     * 
     * @return Action manager package name
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * Set action manager package name.
     * 
     * @param szPackageName New action manager package name to set
     */
    public void setPackageName(String szPackageName) {
        this.packageName = szPackageName;
    }

    /**
     * Returns action manager class name.
     * 
     * @return Action manager class name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Set action manager class name.
     * 
     * @param szClassName New action manager class name to set
     */
    public void setClassName(String szClassName) {
        this.className = szClassName;
    }

    /**
     * Returns action manager configuration file full path.
     * 
     * @return Action manager configuration file full path
     */
    public String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set action manager configuration file full path.
     * 
     * @param szConfigurationFileFullPath New action manager configuration file full path to set
     */
    public void setConfigurationFileFullPath(String szConfigurationFileFullPath) {
        this.configurationFileFullPath = szConfigurationFileFullPath;
    }
}

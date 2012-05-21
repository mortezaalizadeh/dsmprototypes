/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.DSMManifest;

/**
* ActionInfo class is an entity class represent a action.
* 
* @version 0.1, May 20, 2012
  * @author Morteza Alizadeh
 */
public class ActionStartupInfo extends DSMManifest {

    /**
     * Action manager name
     */
    protected String name;

    /**
     * Action manager unique identifier
     */
    protected String uniqueIdentifier;

    /**
     * Action manager library
     */
    protected String library;

    /**
     * Action manager package name
     */
    protected String packageName;

    /**
     * Action manager class name
     */
    protected String className;

    /**
     * Action manager configuration file full path
     */
    protected String configurationFileFullPath;

    /**
     * ActionManagerInfo constructor.
     */
    public ActionStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe4", "Action Info");
        
        this.name = "";
        this.uniqueIdentifier = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
        this.configurationFileFullPath = "";
    }

    /**
     * Returns action manager unique identifier.
     * 
     * @return Action manager unique identifier
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
     * Returns action manager unique identifier.
     * 
     * @return Action manager unique identifier
     */
    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set action manager unique identifier.
     * 
     * @param szUniqueIdentifier New action manager unique identifier to set
     */
    public void setUniqueIdentifier(String szUniqueIdentifier) {
        this.uniqueIdentifier = szUniqueIdentifier;
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
/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.DsmManifest;

/**
* ActionInfo class is an entity class represent a action startup info.
*
* @version 0.1, May 20, 2012
  * @author Morteza Alizadeh
 */
public class ActionStartupInfo extends DsmManifest {

    /**
     * Action manager name.
     */
    private String name;

    /**
     * Action manager library.
     */
    private String library;

    /**
     * Action manager package name.
     */
    private String packageName;

    /**
     * Action manager class name.
     */
    private String className;

    /**
     * Action manager configuration file full path.
     */
    private String configurationFileFullPath;

    /**
     * ActionManagerInfo constructor.
     */
    public ActionStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe4", "Action Startup Info");

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
    public final String getName() {
        return this.name;
    }

    /**
     * Set action manager name.
     *
     * @param newName New action manager name
     */
    public final void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns action manager library.
     *
     * @return Action manager library
     */
    public final String getLibrary() {
        return this.library;
    }

    /**
     * Set action manager library.
     *
     * @param newLibrary New action manager library
     */
    public final void setLibrary(final String newLibrary) {
        this.library = newLibrary;
    }

    /**
     * Returns action manager package name.
     *
     * @return Action manager package name
     */
    public final String getPackageName() {
        return this.packageName;
    }

    /**
     * Set action manager package name.
     *
     * @param newPackageName New action manager package name
     */
    public final void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
    }

    /**
     * Returns action manager class name.
     *
     * @return Action manager class name
     */
    public final String getClassName() {
        return this.className;
    }

    /**
     * Set action manager class name.
     *
     * @param newClassName New action manager class name
     */
    public final void setClassName(final String newClassName) {
        this.className = newClassName;
    }

    /**
     * Returns action manager configuration file full path.
     *
     * @return Action manager configuration file full path
     */
    public final String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set action manager configuration file full path.
     *
     * @param newConfigurationFileFullPath New action manager configuration file full path
     */
    public final void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

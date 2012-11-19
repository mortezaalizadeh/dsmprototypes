/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.action.manager.common;

import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;

/**
 * BasicActionManagerStartupInfo is a basic implementation as an
 * ActionManagerStartupInfo.
 *
 * @version 0.1, November 19, 2012
 * @author Morteza Alizadeh
 */
public class BasicActionManagerStartupInfo extends DsmManifest implements ActionManagerStartupInfo {

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
     * BasicActionManagerStartupInfo constructor.
     */
    public BasicActionManagerStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe3", "Basic Action Manager Startup Info");

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
     * @param newName New action manager name to set
     */
    public void setName(final String newName) {
        this.name = newName;
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
     * @param newLibrary New action manager library to set
     */
    public void setLibrary(final String newLibrary) {
        this.library = newLibrary;
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
     * @param newPackageName New action manager package name to set
     */
    public void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
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
     * @param newClassName New action manager class name to set
     */
    public void setClassName(final String newClassName) {
        this.className = newClassName;
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
     * @param newConfigurationFileFullPath New action manager configuration file full path to set
     */
    public void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

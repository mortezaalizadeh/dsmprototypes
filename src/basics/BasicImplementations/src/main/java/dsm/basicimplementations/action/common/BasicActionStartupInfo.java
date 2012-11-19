/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.action.common;

import dsm.action.common.ActionStartupInfo;
import dsm.common.DsmManifest;

/**
 * BasicActionStartupInfo is a basic implementation for ActionStartupInfo.
 *
 * @version 0.1, November 19, 2012
 * @author Morteza Alizadeh
 */
public class BasicActionStartupInfo extends DsmManifest implements ActionStartupInfo {

    /**
     * Action name.
     */
    private String name;

    /**
     * Action library.
     */
    private String library;

    /**
     * Action package name.
     */
    private String packageName;

    /**
     * Action class name.
     */
    private String className;

    /**
     * Action configuration file full path.
     */
    private String configurationFileFullPath;

    /**
     * BasicActionStartupInfo constructor.
     */
    public BasicActionStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe4", "Basic Action Startup Info");

        this.name = "";
        this.library = "";
        this.packageName = "";
        this.className = "";
        this.configurationFileFullPath = "";
    }

    /**
     * Returns action name.
     *
     * @return Action name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set action name.
     *
     * @param newName New action name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns action library.
     *
     * @return Action library
     */
    public String getLibrary() {
        return this.library;
    }

    /**
     * Set action library.
     *
     * @param newLibrary New action library
     */
    public void setLibrary(final String newLibrary) {
        this.library = newLibrary;
    }

    /**
     * Returns action package name.
     *
     * @return Action package name
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * Set action package name.
     *
     * @param newPackageName New action package name
     */
    public void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
    }

    /**
     * Returns action class name.
     *
     * @return Action class name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Set action class name.
     *
     * @param newClassName New action class name
     */
    public void setClassName(final String newClassName) {
        this.className = newClassName;
    }

    /**
     * Returns action configuration file full path.
     *
     * @return Action configuration file full path
     */
    public String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set action configuration file full path.
     *
     * @param newConfigurationFileFullPath New action configuration file full path
     */
    public void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

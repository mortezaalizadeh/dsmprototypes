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
     * Unique identifier.
     */
    private String uniqueIdentifier = "";

    /**
     * Library.
     */
    private String library = "";

    /**
     * Package name.
     */
    private String packageName = "";

    /**
     * Class name.
     */
    private String className = "";

    /**
     * Configuration file full path.
     */
    private String configurationFileFullPath = "";

    /**
     * BasicActionStartupInfo constructor.
     */
    public BasicActionStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe4", "Basic Action Startup Information");
    }

    /**
     * Returns unique identifier.
     *
     * @return Unique identifier
     */
    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set unique identifier.
     *
     * @param newUniqueIdentifier New unique identifier
     */
    public void setUniqueIdentifier(final String newUniqueIdentifier) {
        this.uniqueIdentifier = newUniqueIdentifier;
    }

    /**
     * Returns library.
     *
     * @return Library
     */
    public String getLibrary() {
        return this.library;
    }

    /**
     * Set library.
     *
     * @param newLibrary New library
     */
    public void setLibrary(final String newLibrary) {
        this.library = newLibrary;
    }

    /**
     * Returns package name.
     *
     * @return Package name
     */
    public String getPackageName() {
        return this.packageName;
    }

    /**
     * Set package name.
     *
     * @param newPackageName New package name
     */
    public void setPackageName(final String newPackageName) {
        this.packageName = newPackageName;
    }

    /**
     * Returns class name.
     *
     * @return Class name
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Set class name.
     *
     * @param newClassName New class name
     */
    public void setClassName(final String newClassName) {
        this.className = newClassName;
    }

    /**
     * Returns configuration file full path.
     *
     * @return Configuration file full path
     */
    public String getConfigurationFileFullPath() {
        return this.configurationFileFullPath;
    }

    /**
     * Set configuration file full path.
     *
     * @param newConfigurationFileFullPath New configuration file full path
     */
    public void setConfigurationFileFullPath(final String newConfigurationFileFullPath) {
        this.configurationFileFullPath = newConfigurationFileFullPath;
    }
}

/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.action.manager.common;

import dsm.action.common.ActionStartupInfo;
import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;
import java.util.HashSet;
import java.util.Set;

/**
 * BasicActionManagerStartupInfo is a basic implementation for
 * ActionManagerStartupInfo.
 *
 * @version 0.1, November 19, 2012
 * @author Morteza Alizadeh
 */
public class BasicActionManagerStartupInfo extends DsmManifest implements ActionManagerStartupInfo {

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
     * List of action startup information.
     */
    private Set<ActionStartupInfo> actionStartupInfoList = null;

    /**
     * BasicActionManagerStartupInfo constructor.
     */
    public BasicActionManagerStartupInfo() {
        super("70feef0d-bb9e-4bb2-998f-8bba70fbefe3", "Basic Action Manager Startup Information");
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

    /**
     * Adds new action startup information.
     *
     * @param actionStartupInfo Reference to action startup
     * information to add
     */
    public void addActionStartupInfo(final ActionStartupInfo actionStartupInfo) {
        if (actionStartupInfo == null) {
            throw new IllegalArgumentException("actionStartupInfo");
        }

        this.getActionStartupInfoList().add(actionStartupInfo);
    }

    /**
     * Removes already added action startup information.
     *
     * @param actionStartupInfo Reference to action startup
     * information to remove
     */
    public void removeActionStartupInfo(final ActionStartupInfo actionStartupInfo) {
        if (actionStartupInfo == null) {
            throw new IllegalArgumentException("actionStartupInfo");
        }

        this.getActionStartupInfoList().remove(actionStartupInfo);
    }

    /**
     * Returns the number of added action startup information.
     *
     * @return Returns the number of added action startup information
     */
    public Integer getActionStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionStartupInfoList != null) {
            count = this.actionStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the list of action startup information.
     *
     * @return List of action startup information
     */
    public Set<ActionStartupInfo> getActionStartupInfoList() {
        if (this.actionStartupInfoList == null) {
            this.actionStartupInfoList = new HashSet<ActionStartupInfo>();
        }

        return this.actionStartupInfoList;
    }

    /**
     * Sets list of action startup information.
     *
     * @param newActionStartupInfoList New action startup information list
     */
    protected void setActionStartupInfoList(final Set<ActionStartupInfo> newActionStartupInfoList) {
        this.actionStartupInfoList = newActionStartupInfoList;
    }
}

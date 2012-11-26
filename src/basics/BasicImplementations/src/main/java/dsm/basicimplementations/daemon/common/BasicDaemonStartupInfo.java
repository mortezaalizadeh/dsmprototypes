/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.daemon.common;

import dsm.action.manager.common.ActionManagerStartupInfo;
import dsm.common.DsmManifest;
import dsm.daemon.common.DaemonStartupInfo;
import java.util.HashSet;
import java.util.Set;

/**
 * BasicDaemonStartupInfo is a basic implementation for DaemonStartupInfo.
 *
 * @version 0.1, November 17, 2012
 * @author Morteza Alizadeh
 */
public class BasicDaemonStartupInfo extends DsmManifest implements DaemonStartupInfo {

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
     * List of action manager startup information.
     */
    private Set<ActionManagerStartupInfo> actionManagerStartupInfoList = null;

    /**
     * BasicDaemonStartupInfo constructor.
     */
    public BasicDaemonStartupInfo() {
        super("634b7eab-c77f-494b-b10a-a646288ca16a", "Basic Daemon Startup Information");
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
     * Adds new action manager startup information.
     *
     * @param actionManagerStartupInfo Reference to action manager startup
     * information to add
     */
    public void addActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo) {
        if (actionManagerStartupInfo == null) {
            throw new IllegalArgumentException("actionManagerStartupInfo");
        }

        this.getActionManagerStartupInfoList().add(actionManagerStartupInfo);
    }

    /**
     * Removes already added action manager startup information.
     *
     * @param actionManagerStartupInfo Reference to action manager startup
     * information to remove
     */
    public void removeActionManagerStartupInfo(final ActionManagerStartupInfo actionManagerStartupInfo) {
        if (actionManagerStartupInfo == null) {
            throw new IllegalArgumentException("actionManagerStartupInfo");
        }

        this.getActionManagerStartupInfoList().remove(actionManagerStartupInfo);
    }

    /**
     * Returns the number of added action manager startup information.
     *
     * @return Returns the number of added action manager startup information
     */
    public Integer getActionManagerStartupInfoCount() {
        Integer count = Integer.valueOf(0);

        if (this.actionManagerStartupInfoList != null) {
            count = this.actionManagerStartupInfoList.size();
        }

        return count;
    }

    /**
     * Returns the list of action manager startup information.
     *
     * @return List of action manager startup information
     */
    public Set<ActionManagerStartupInfo> getActionManagerStartupInfoList() {
        if (this.actionManagerStartupInfoList == null) {
            this.actionManagerStartupInfoList = new HashSet<ActionManagerStartupInfo>();
        }

        return this.actionManagerStartupInfoList;
    }

    /**
     * Sets list of action manager startup information.
     *
     * @param newActionManagerStartupInfoList New action manager startup information list
     */
    protected void setActionManagerStartupInfoList(final Set<ActionManagerStartupInfo> newActionManagerStartupInfoList) {
        this.actionManagerStartupInfoList = newActionManagerStartupInfoList;
    }
}

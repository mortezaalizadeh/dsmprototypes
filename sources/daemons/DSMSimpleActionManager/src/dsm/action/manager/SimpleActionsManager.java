/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager;

import dsm.action.manager.common.ActionsManager;
import dsm.common.DSMManifest;

/**
 * SimpleActionsManager.
 * 
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public class SimpleActionsManager extends DSMManifest implements ActionsManager {
    
    /**
     * Actions manager name
     */
    private String actionsManagerName = "Simple Actions Manager";

    /**
     * Actions manager initialization state
     */
    private boolean inited = false;

    /**
     * SimpleActionsManager Constructor
     * 
     */
    public SimpleActionsManager() {
        super("6a0df21c-ffe0-4fad-a402-a147afd7fd88", "Simple Actions Manager");
    }

    /**
     * Returns actions manager name.
     * 
     * @return Actions manager name
     */
    @Override
    public String getActionsManagerName() {
        return actionsManagerName;
    }

    /**
     * Returns whether actions manager is initialized.
     * 
     * @return Actions manager initialization status
     */
    @Override
    public boolean isInited() {
        return inited;
    }

    /**
     * Initialize SimpleActionsManager module and allocate all required
     * resources.
     * 
     * @param initializationParams Contains initializations parameters
     */
    @Override
    public void init(String initializationParams) {
        inited = true;
    }

    /**
     * Shutdown SimpleActionsManager module and free all allocated resources
     * by it.
     */
    @Override
    public void shutdown() {
        inited = false;
    }
}

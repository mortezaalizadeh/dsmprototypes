/**
 * @author Morteza Alizadeh
 */
package dsm.action.repository;

import dsm.action.repository.common.ActionsRepository;
import dsm.common.DSMManifest;

/**
 * ActionRepository keeps track of registered actions in DSM.
 * 
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public class SimpleActionsRepository extends DSMManifest implements ActionsRepository {
    
    /**
     * Actions repository name
     */
    private String actionsRepositoryName = "Simple Actions Repository";

    /**
     * Actions Repository initialization state
     */
    private boolean inited = false;

    /**
     * SimpleActionsRepository Constructor
     * 
     */
    public SimpleActionsRepository() {
        super("6a0df21c-ffe0-4fad-a402-a147afd7fd88", "Simple Actions Repository");
    }

    /**
     * Returns actions repository name.
     * 
     * @return Actions repository name
     */
    @Override
    public String getActionsRepositoryName() {
        return actionsRepositoryName;
    }

    /**
     * Returns whether actions repository is initialized.
     * 
     * @return Actions repository initialization status
     */
    @Override
    public boolean isInited() {
        return inited;
    }

    /**
     * Initialize SimpleActionsRepository module and allocate all required
     * resources.
     */
    @Override
    public void init() {
        inited = true;
    }

    /**
     * Shutdown SimpleActionsRepository module and free all allocated resources
     * by it.
     */
    @Override
    public void shutdown() {
        inited = false;
    }
}

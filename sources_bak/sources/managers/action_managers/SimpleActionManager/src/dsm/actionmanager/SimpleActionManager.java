/**
 * @author Morteza Alizadeh
 */
package dsm.actionmanager;

import dsm.action.manager.common.ActionManager;
import dsm.common.DSMManifest;

/**
 * SimpleActionManager is a simple action manager.
 * 
 * @version 0.1, May 21, 2012
 * @author Morteza Alizadeh
 */
public class SimpleActionManager extends DSMManifest implements ActionManager {
    
    /**
     * Action manager name
     */
    protected String actionManagerName = "Simple Action Manager";

    /**
     * Action manager initialization state
     */
    private boolean inited = false;

    /**
     * SimpleActionManager Constructor
     * 
     * @param szActionManagerName Action manager name
     */
    public SimpleActionManager(String szActionManagerName) {
        super("114cae51-e05b-4961-99f4-06df89eb022b", "Simple Action Manager");
        
        this.actionManagerName = szActionManagerName;
    }

    /**
     * Returns action manager name.
     * 
     * @return Action manager name
     */
    @Override
    public String getActionManagerName() {
        return this.actionManagerName;
    }

    /**
     * Returns whether action manager is initialized.
     * 
     * @return Action manager initialization status
     */
    @Override
    public boolean isInited() {
        return this.inited;
    }

    /**
     * Initializes action manager.
     * 
     * @param initializationParams Contains initializations parameters
     */
    @Override
    public void init(String initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown action manager.
     */
    @Override
    public void shutdown() {
        this.inited = false;
    }
}

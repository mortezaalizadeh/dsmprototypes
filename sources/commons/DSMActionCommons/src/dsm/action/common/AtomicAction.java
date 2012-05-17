/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.DSMManifest;
import dsm.common.argument.ArgumentContainer;

/**
 * AtomicAction abstract class provides basic operations and attributes to all
 * atomic action classes.
 * 
 * This class must be inherited by all atomic action classes in order to use
 * standardized operations and attributes for them.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public abstract class AtomicAction extends DSMManifest implements Action {

    /**
     * Action name
     */
    protected String actionName = "No name specified yet!!!";

    /**
     * Action type
     */
    protected ActionType actionType = ActionType.Atomic;

    /**
     * AuthorityModality Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szActionName Action name
     */
    public AtomicAction(String szUniqueId, String szFriendlyName, String szActionName) {
        super(szUniqueId, szFriendlyName);
        
        this.actionName = szActionName;
    }

    /**
     * Returns action name.
     * 
     * @return Action name
     */
    @Override
    public String getActionName() {
        return this.actionName;
    }

    /**
     * Returns action type.
     * 
     * @return Action type
     */
    @Override
    public ActionType getActionType() {
        return this.actionType;
    }

    /**
     * Executes atomic action.
     * 
     * This method is the call entry for other modules which intend to execute
     * the atomic action.
     * 
     * @param arguments Argument container
     */
    @Override
    public void executeAction(ArgumentContainer argumentContainer) {
    }
}

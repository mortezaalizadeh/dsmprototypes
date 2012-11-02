/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.DsmManifest;
import dsm.common.argument.ArgumentContainer;

/**
 * DistributedAction abstract class provides basic operations and attributes
 * to all distributed action classes.
 * 
 * This class must be inherited by all distributed action classes in order to
 * use standardized operations and attributes for them.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public abstract class DistributedAction extends DsmManifest implements Action {

    /**
     * Action name
     */
    protected String actionName = "No name specified yet!!!";

    /**
     * Action type
     */
    protected ActionType actionType = ActionType.Distributed;

    /**
     * AuthorityModality Constructor
     * 
     * @param szUniqueId DSM object unique identifier
     * @param szFriendlyName DSM object friendly name
     * @param szActionName Action name
     */
    public DistributedAction(String szUniqueId, String szFriendlyName, String szActionName) {
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
     * Executes distributed action.
     * 
     * This method is the call entry for other modules which intend to execute
     * the distributed action.
     * 
     * @param arguments Argument container
     */
    @Override
    public void executeAction(ArgumentContainer argumentContainer) {
    }
}

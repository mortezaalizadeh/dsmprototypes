/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.MultiArguments;

/**
 * Action interface defines general operations and attributes for an action.
 * 
 * This interface must be implemented by all action classes.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public interface Action {
    
    /**
     * Returns action name.
     * 
     * @return Action name
     */
    String getActionName();

    /**
     * Returns action type.
     * 
     * @return Action type
     */
    ActionType getActionType();

    /**
     * Executes action.
     * 
     * This method is the call entry for other modules which intend to execute
     * the action.
     * 
     * @param arguments Argument list
     */
    void executeAction(MultiArguments arguments);
}

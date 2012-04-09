/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.error.common.DSMGeneralErrorInfo;

/**
 * Action interface defines general operations and attributes for a policy
 * action.
 * 
 * This interface must be implemented by all policy action classes.
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
     * @param errorInfo Contains error info if any error or exception occurs in
     * return. Passing null would not return occurred error and method only
     * returns false
     * 
     * @return Returns true if action execution is successfully done and the
     * value is returned, otherwise return false and errorInfo contains occurred
     * error info
     */
    boolean executeAction(DSMGeneralErrorInfo errorInfo);
}

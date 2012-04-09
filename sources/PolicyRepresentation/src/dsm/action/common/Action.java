/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

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
}

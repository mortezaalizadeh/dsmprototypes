/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager.common;

/**
 * ActionsManager interface defines general operations and attributes for a
 * actions manager.
 * 
 * This interface must be implemented by all actions manager classes.
 * 
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public interface ActionsManager {
    
    /**
     * Returns actions manager name.
     * 
     * @return Actions manager name
     */
    String getActionsManagerName();

    /**
     * Returns whether actions manager is initialized.
     * 
     * @return Actions manager initialization status
     */
    boolean isInited();

    /**
     * Initializes actions manager.
     * 
     * @param initializationParams Contains initializations parameters
     */
    public void init(String initializationParams);

    /**
     * Shutdown actions manager.
     */
    void shutdown();
}

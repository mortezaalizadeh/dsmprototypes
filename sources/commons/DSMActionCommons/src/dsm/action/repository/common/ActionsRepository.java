/**
 * @author Morteza Alizadeh
 */
package dsm.action.repository.common;

/**
 * ActionsRepository interface defines general operations and attributes for a
 * actions repository.
 * 
 * This interface must be implemented by all actions repository classes.
 * 
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public interface ActionsRepository {
    
    /**
     * Returns actions repository name.
     * 
     * @return Actions repository name
     */
    String getActionsRepositoryName();

    /**
     * Returns whether actions repository is initialized.
     * 
     * @return Actions repository initialization status
     */
    boolean isInited();

    /**
     * Initializes actions repository.
     * 
     * @param initializationParams Contains initializations parameters
     */
    public void init(String initializationParams);

    /**
     * Shutdown actions repository.
     */
    void shutdown();
}

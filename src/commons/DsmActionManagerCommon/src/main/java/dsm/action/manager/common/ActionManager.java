/**
 * @author Morteza Alizadeh
 */
package dsm.action.manager.common;

import dsm.common.argument.ArgumentContainer;

/**
 * ActionManager interface defines general operations and attributes for a
 * action manager.
 *
 * This interface must be implemented by all action manager classes.
 *
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public interface ActionManager {

    /**
     * Returns action manager name.
     *
     * @return Action manager name
     */
    String getActionManagerName();

    /**
     * Returns whether action manager is initialized.
     *
     * @return Action manager initialization status
     */
    boolean isInited();

    /**
     * Initializes action manager.
     *
     * @param initializationParams Contains initializations parameters
     */
    void init(final ArgumentContainer initializationParams);

    /**
     * Shutdown action manager.
     */
    void shutdown();
}

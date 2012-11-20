/**
 * @author Morteza Alizadeh
 */
package dsm.actionmanager;

import dsm.action.manager.common.ActionManager;
import dsm.common.DsmManifest;
import dsm.common.argument.ArgumentContainer;

/**
 * SimpleActionManager is a simple action manager.
 *
 * @version 0.1, May 21, 2012
 * @author Morteza Alizadeh
 */
public class SimpleActionManager extends DsmManifest implements ActionManager {

    /**
     * Action manager name.
     */
    private static final String ACTION_MANAGER_NAME = "Simple Action Manager";

    /**
     * Action manager initialization state.
     */
    private transient boolean inited = false;

    /**
     * SimpleActionManager Constructor.
     */
    public SimpleActionManager() {
        super("114cae51-e05b-4961-99f4-06df89eb022b", "Simple Action Manager");
    }

    /**
     * Returns action manager name.
     *
     * @return Action manager name
     */
    public final String getActionManagerName() {
        return SimpleActionManager.ACTION_MANAGER_NAME;
    }

    /**
     * Returns whether action manager is initialized.
     *
     * @return Action manager initialization status
     */
    public final boolean isInited() {
        return this.inited;
    }

    /**
     * Initializes action manager.
     *
     * @param initializationParams Contains initializations parameters
     */
    public final void init(final ArgumentContainer initializationParams) {
        this.inited = true;
    }

    /**
     * Shutdown action manager.
     */
    public final void shutdown() {
        this.inited = false;
    }
}

/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

import dsm.common.DsmManifest;
import dsm.common.argument.ArgumentContainer;

/**
 * AbstractAtomicAction abstract class provides basic operations and attributes to all
 * atomic action classes.
 *
 * This class must be inherited by all atomic action classes in order to use
 * standardized operations and attributes for them.
 *
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public abstract class AbstractAtomicAction extends DsmManifest implements Action {

    /**
     * Action name.
     */
    private String actionName = "No name specified yet!!!";

    /**
     * Action type.
     */
    private ActionType actionType = ActionType.Atomic;

    /**
     * AuthorityModality Constructor.
     *
     * @param newDsmUniqueIdentifier Dsm object unique identifier
     * @param newDsmFriendlyName Dsm object friendly name
     * @param newActionName Action name
     */
    public AbstractAtomicAction(final String newDsmUniqueIdentifier,
                                final String newDsmFriendlyName,
                                final String newActionName) {
        super(newDsmUniqueIdentifier, newDsmFriendlyName);

        this.actionName = newActionName;
    }

    /**
     * Returns action name.
     *
     * @return Action name
     */
    public String getActionName() {
        return this.actionName;
    }

    /**
     * Sets action name.
     *
     * @param newActionName New action name
     */
    public void setActionName(final String newActionName) {
        this.actionName = newActionName;
    }

    /**
     * Returns action type.
     *
     * @return Action type
     */
    public ActionType getActionType() {
        return this.actionType;
    }

    /**
     * Sets action type.
     *
     * @param newActionType New action type
     */
    public void setActionType(final ActionType newActionType) {
        this.actionType = newActionType;
    }

    /**
     * Executes atomic action.
     *
     * This method is the call entry for other modules which intend to execute
     * the atomic action.
     *
     * @param argumentContainer Argument container
     */
    public abstract void executeAction(final ArgumentContainer argumentContainer);
}

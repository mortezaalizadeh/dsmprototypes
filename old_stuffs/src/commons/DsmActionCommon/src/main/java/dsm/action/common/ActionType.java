/**
 * @author Morteza Alizadeh
 */
package dsm.action.common;

/**
 * ModalityType defines different modality types.
 *
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public enum ActionType {

    /**
     * Action require to be run only on local device and not allowed to be
     * distributed.
     */
    Atomic,

    /**
     * Action which can be run either on local machine or remote machine using
     * action distribution engine.
     */
    Distributed
}


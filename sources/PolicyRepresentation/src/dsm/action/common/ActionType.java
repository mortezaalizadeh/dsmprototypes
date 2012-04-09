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
     * Actions require to be run only on local device and not allowed to be
     * distributed.
     */
    Atomic,

    /**
     * Actions which can be run either on local machine or remote machine using
     * action distribution engine.
     */
    Distributed
}


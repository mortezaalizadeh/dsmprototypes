/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.modality.common;

/**
 * ModalityType defines different modality types.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public enum ModalityType {

    /**
     * Obligation policy gives an agent the imperative to carry out an action
     * provided he has the power to do so.
     */
    Obligation,

    /**
     * Authority policy provides an agent with the legitimate power to perform
     * an action such as the operations an agent is permitted to perform on a
     * target object.
     */
    Authority
}

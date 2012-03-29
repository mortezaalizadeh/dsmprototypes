/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.objective.common;

/**
 * Objective interface defines general operations and attributes for a policy
 * objective.
 * 
 * This interface must be implemented by all policy objective classes.
 * 
 * We use the term policy objectives for the aims of a policy. Objectives are
 * expressed as a pair of goals and target objects. The policy goal defines
 * either a high-level goal or a procedure. Procedures are a defined sequence
 * of actions. Any goal which is expressed purely in terms of an alphabet of
 * operations on objects in a system (i.e. a defined sequence of actions), is a
 * procedure, otherwise it is to be regarded as a high-level goal, which
 * requires refinement in order to define the actions which will achieve it.
 * 
 * @version 0.1, March 17, 2012
 * @author Morteza Alizadeh
 */
public interface Objective {

    /**
     * Returns objective name.
     * 
     * @return Objective name
     */
    String getObjectiveName();
}

/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.constraint.common;

/**
 * Constraint interface defines general operations and attributes for a policy
 * constraint.
 * 
 * This interface must be implemented by all policy constraint classes.
 * 
 * Constraints are a set of predicates which constrain the applicability of the
 * policy. They may be expressed in terms of general system properties, such as
 * extent or duration, or some other condition. An example of constraints in
 * authority policies expressed by access rules is the limits on the terminal
 * from which the operation may be performed, and/or limits on date or time.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface Constraint {

    /**
     * Returns constraint name.
     * 
     * @return Constraint name
     */
    String getConstraintName();
}

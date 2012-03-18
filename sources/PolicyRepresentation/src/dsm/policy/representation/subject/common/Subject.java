/**
 * @author Morteza Alizadeh
 */
package dsm.policy.representation.subject.common;

/**
 * Subject interface defines general operations and attributes for a policy
 * subject.
 * 
 * This interface must be implemented by all policy subject classes.
 * 
 * The policy subjects are the entities to whom the policy is directed, i.e.
 * who are authorized or obliged to carry out the policy objective. The subjects
 * may be human or automated. Policy subjects are typically specified as sets,
 * because a policy is typically expressed in terms of organizational positions
 * and domains of objects, not individuals.
 * 
 * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface Subject {

    /**
     * Returns subject name.
     * 
     * @return Subject name
     */
    String getSubjectName();
}

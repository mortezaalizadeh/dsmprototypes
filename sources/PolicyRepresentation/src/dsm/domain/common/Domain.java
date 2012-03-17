/**
 * @author Morteza Alizadeh
 */
package dsm.domain.common;

/**
 * Domain interface defines general operations and attributes for a domain.
 * 
 * This interface must be implemented by all different type of domain classes.
 * 
  * @version 0.1, March 17th, 2012
 * @author Morteza Alizadeh
 */
public interface Domain {

    /**
     * Returns policy domain friendly name.
     * @return Policy domain friendly name
     */
    String getDomainName();
}

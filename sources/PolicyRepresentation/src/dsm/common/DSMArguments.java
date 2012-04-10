/**
 * @author Morteza Alizadeh
 */
package dsm.common;

import java.util.HashMap;

/**
 * DSMArguments class defines a standard pair values to pass variable type and
 * number of parameters to a method.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class DSMArguments {

    HashMap argumentList = null;
    
    /**
     * DSMArguments Constructor
     */
    public DSMArguments() {
    }

    /**
     * Adds/Modifies argument to/in argument list.
     * 
     * @param szName Argument name
     * @param value Argument value
     */
    public void setArgument(String szName, Object value) {
        if (argumentList == null)
            argumentList = new HashMap();
        
        argumentList.put(szName, value);
    }

    /**
     * Returns argument value from stored list of arguments.
     * 
     * @param szName Argument name to retrieve value
     * @return Returns argument value
     */
    public Object getArgument(String szName) {
        if (argumentList == null)
            return null;
        
        if (argumentList.isEmpty())
            return null;
        
        return argumentList.get(szName);
    }

    /**
     * Clears all already stored arguments.
     */
    public void clear() {
        if (argumentList != null)
            argumentList.clear();
        
        argumentList = null;
    }
}

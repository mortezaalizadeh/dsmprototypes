/**
 * @author Morteza Alizadeh
 */
package dsm.common.argument;

import dsm.common.DSMManifest;
import java.util.HashMap;

/**
 * ArgumentContainer.
 * 
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public class ArgumentContainer extends DSMManifest {

    HashMap argumentList = null;
    
    /**
     * MultiArguments Constructor
     */
    public ArgumentContainer() {
        super("e5320f27-fcda-407e-9016-3c43c547ba80", "Argument Contianter");
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

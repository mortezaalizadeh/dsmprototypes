/**
 * @author Morteza Alizadeh
 */
package dsm.common.argument;

import dsm.common.DsmManifest;
import java.util.HashMap;
import java.util.Map;

/**
 * ArgumentContainer.
 * 
 * @version 0.1, April 14, 2012
 * @author Morteza Alizadeh
 */
public class ArgumentContainer extends DsmManifest {

    /**
     * List of current stored arguments.
     */
    private transient Map<String, Object> argumentList = null;

    /**
     * MultiArguments Constructor
     */
    public ArgumentContainer() {
        super("e5320f27-fcda-407e-9016-3c43c547ba80", "Argument Contianter");
    }

    /**
     * Adds/Modifies argument to/in argument list.
     * 
     * @param name Argument name
     * @param value Argument value
     */
    public void setArgument(final String name, final Object value) {
        if (this.argumentList == null) {
            this.argumentList = new HashMap<String, Object>();
        }
        
        this.argumentList.put(name, value);
    }

    /**
     * Returns argument value from stored list of arguments.
     * 
     * @param szName Argument name to retrieve value
     * @return Returns argument value
     */
    public Object getArgument(final String name) {
        Object foundValue = null;
        
        do {
            if (this.argumentList == null) {
                break;
            }

            if (this.argumentList.isEmpty()) {
                break;
            }

            foundValue = this.argumentList.get(name);
        }while(false);
        
        return foundValue;
    }

    /**
     * Clears all already stored arguments.
     */
    public void clear() {
        if (this.argumentList != null) {
            this.argumentList.clear();
        }
    }
}

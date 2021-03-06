/**
 * @author Morteza Alizadeh
 */
package dsm.basicimplementations.common.argument;

import dsm.common.DsmManifest;
import dsm.common.argument.ArgumentContainer;
import java.util.HashMap;
import java.util.Map;

/**
 * BasicArgumentContainer is a basic implementation for ArgumentContainer.
 *
 * @version 0.1, November 14, 2012
 * @author Morteza Alizadeh
 */
public class BasicArgumentContainer extends DsmManifest implements ArgumentContainer {

    /**
     * List of current stored arguments.
     */
    private Map<String, Object> argumentList = null;

    /**
     * BasicArgumentContainer Constructor.
     */
    public BasicArgumentContainer() {
        super("e5320f27-fcda-407e-9016-3c43c547ba80", "Basic Argument Contianter");
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
     * @param name Argument name to retrieve value
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
        } while(false);

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

    /**
     * Returns argument list.
     *
     * @return Returns argument list
     */
    protected Map<String, Object> getArgumentList() {
        return this.argumentList;
    }

    /**
     * Sets argument list.
     *
     * @param newArgumentList New argument list
     */
    protected void setArgumentList(final Map<String, Object> newArgumentList) {
        argumentList = newArgumentList;
    }
}

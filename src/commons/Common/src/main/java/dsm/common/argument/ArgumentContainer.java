/**
 * @author Morteza Alizadeh
 */
package dsm.common.argument;

/**
 * ArgumentContainer interface defines methods require to implement variable
 * size of input/output arguments.
 *
 * This interface must be implemented by all ArgumentContainter implementations.
 *
 * @version 0.1, November 11, 2012
 * @author Morteza Alizadeh
 */
public interface ArgumentContainer {

    /**
     * Adds/Modifies argument to/in argument list.
     *
     * @param name Argument name
     * @param value Argument value
     */
    void setArgument(final String name, final Object value);

    /**
     * Returns argument value from stored list of arguments.
     *
     * @param name Argument name to retrieve value
     * @return Returns argument value
     */
    Object getArgument(final String name);

    /**
     * Clears all already stored arguments.
     */
    void clear();
}

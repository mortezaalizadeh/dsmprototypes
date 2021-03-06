/**
 * @author Morteza Alizadeh
 */
package dsm.action.atomic.simpleactions;

import dsm.action.common.AbstractAtomicAction;
import dsm.common.argument.ArgumentContainer;

/**
 * LocalTextFileWriter is a simple local content saver which stores information
 * into file.
 *
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class LocalTextFileWriter extends AbstractAtomicAction {

    /**
     * TextFileWriter Constructor.
     */
    public LocalTextFileWriter() {
        super("9ede7704-ae67-4d06-8a7a-b07d4aa8ba1b", "LocalTextFileWriter Action", "LocalTextFileWriter Action");
    }

    /**
     * Executes action.
     *
     * This methods reads filename as a first argument and string content as a
     * second argument and save content into file.
     *
     * @param argumentContainer Argument container
     */
    @Override
    public void executeAction(final ArgumentContainer argumentContainer) {
    }
}

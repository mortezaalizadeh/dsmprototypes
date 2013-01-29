/**
 * @author Morteza Alizadeh
 */
package dsm.action.atomic.simpleactions;

import dsm.action.common.AbstractAtomicAction;
import dsm.common.argument.ArgumentContainer;

/**
 * LocalTextFileReader is a simple local content reader which read information
 * from file.
 *
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class LocalTextFileReader extends AbstractAtomicAction {

    /**
     * TextFileReader Constructor.
     */
    public LocalTextFileReader() {
        super("44fb2802-5455-47a5-bcc6-e151fb80b38a", "LocalTextFileReader Action", "LocalTextFileReader Action");
    }

    /**
     * Executes action.
     *
     * This methods reads filename as a first argument and reads the entire
     * content and copy that into second argument as an string object.
     *
     * @param argumentContainer Argument container
     */
    @Override
    public void executeAction(final ArgumentContainer argumentContainer) {
    }
}

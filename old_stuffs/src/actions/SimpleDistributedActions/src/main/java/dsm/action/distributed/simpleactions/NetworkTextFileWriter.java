/**
 * @author Morteza Alizadeh
 */
package dsm.action.distributed.simpleactions;

import dsm.action.common.AbstractAtomicAction;
import dsm.common.argument.ArgumentContainer;

/**
 * NetworkTextFileWriter is a simple content saver which stores information into
 * file on the network.
 *
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public class NetworkTextFileWriter extends AbstractAtomicAction {

    /**
     * TextFileWriter Constructor.
     */
    public NetworkTextFileWriter() {
        super("913c2e47-7cac-4831-b1c4-93caed52a4e6", "NetworkTextFileWriter Action", "NetworkTextFileWriter Action");
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

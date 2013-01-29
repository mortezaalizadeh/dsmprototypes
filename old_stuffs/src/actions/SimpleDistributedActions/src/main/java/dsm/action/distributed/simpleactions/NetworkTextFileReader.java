/**
 * @author Morteza Alizadeh
 */
package dsm.action.distributed.simpleactions;

import dsm.action.common.AbstractAtomicAction;
import dsm.common.argument.ArgumentContainer;

/**
 * NetworkTextFileReader is a simple content reader which read information from
 * file on the network.
 *
 * @version 0.1, April 13, 2012
 * @author Morteza Alizadeh
 */
public class NetworkTextFileReader extends AbstractAtomicAction {

    /**
     * TextFileReader Constructor.
     */
    public NetworkTextFileReader() {
        super("ecae1f7f-b6fb-4c11-93de-060d98e9bdf2", "NetworkTextFileReader Action", "NetworkTextFileReader Action");
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

/**
 * @author Morteza Alizadeh
 */
package dsm.action.simpleactions;

import dsm.action.common.AtomicAction;
import dsm.common.MultiArguments;

/**
 * TextFileReader is a simple content reader which read information from file.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class TextFileReader extends AtomicAction {

    /**
     * TextFileReader Constructor
     * 
     */
    public TextFileReader() {
        super("44fb2802-5455-47a5-bcc6-e151fb80b38a", "TextFileReader Action", "TextFileReader Action");
    }
    
    /**
     * Executes action.
     * 
     * This methods reads filename as a first argument and reads the entire
     * content and copy that into second argument as an string object.
     * 
     * @param arguments Argument list
     */
    @Override
    public void executeAction(MultiArguments arguments) {
    }
}

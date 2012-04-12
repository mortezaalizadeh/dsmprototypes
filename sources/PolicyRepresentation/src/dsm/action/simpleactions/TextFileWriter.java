/**
 * @author Morteza Alizadeh
 */
package dsm.action.simpleactions;

import dsm.action.common.AtomicAction;
import dsm.common.MultiArguments;

/**
 * TextFileWriter is a simple content saver which stores information into file.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class TextFileWriter extends AtomicAction {

    /**
     * TextFileWriter Constructor
     * 
     */
    public TextFileWriter() {
        super("9ede7704-ae67-4d06-8a7a-b07d4aa8ba1b", "TextFileWriter Action", "TextFileWriter Action");
    }
    
    /**
     * Executes action.
     * 
     * This methods reads filename as a first argument and string content as a
     * second argument and save content into file.
     * 
     * @param arguments Argument list
     */
    @Override
    public void executeAction(MultiArguments arguments) {
    }
}

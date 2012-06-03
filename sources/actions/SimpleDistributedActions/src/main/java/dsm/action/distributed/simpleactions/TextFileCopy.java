/**
 * @author Morteza Alizadeh
 */
package dsm.action.distributed.simpleactions;

import dsm.action.common.AtomicAction;
import dsm.common.argument.ArgumentContainer;

/**
 * TextFileCopy is a simple text file copier.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class TextFileCopy extends AtomicAction {

    /**
     * TextFileReader Constructor
     */
    public TextFileCopy() {
        super("c2d1ce7b-d685-456f-9f0a-ec50729ac1e0", "TextFileCopy Action", "TextFileCopy Action");
    }
    
    /**
     * Executes action.
     * 
     * This methods reads filename as a first argument and copies that with the
     * same name as specified in second argument.
     * 
     * @param arguments Argument container
     */
    @Override
    public void executeAction(ArgumentContainer argumentContainer) {
    }
}

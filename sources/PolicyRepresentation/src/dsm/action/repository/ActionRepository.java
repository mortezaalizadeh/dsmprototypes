/**
 * @author Morteza Alizadeh
 */
package dsm.action.repository;

import dsm.common.DSMManifest;

/**
 * ActionRepository is a singleton class keeps track of registered actions in
 * DSM.
 * 
 * @version 0.1, April 10, 2012
 * @author Morteza Alizadeh
 */
public class ActionRepository extends DSMManifest {
    
    private static ActionRepository singletonInstance;
    
    /**
     * ActionRepository Constructor
     * 
     */
    private ActionRepository() {
        super("6a0df21c-ffe0-4fad-a402-a147afd7fd88", "Action Repository");
    }

    public static synchronized ActionRepository getSingletonObject() {
        if (singletonInstance == null)
            singletonInstance = new ActionRepository();

        return singletonInstance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

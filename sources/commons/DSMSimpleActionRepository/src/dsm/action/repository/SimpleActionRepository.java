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
public class SimpleActionRepository extends DSMManifest {
    
    private static SimpleActionRepository singletonInstance;
    
    /**
     * ActionRepository Constructor
     * 
     */
    private SimpleActionRepository() {
        super("6a0df21c-ffe0-4fad-a402-a147afd7fd88", "Action Repository");
    }

    /**
     * Returns singleton instance of ActionRepository class.
     * 
     * @return Singleton instance of ActionRepository class
     */
    public static synchronized SimpleActionRepository getSingletonObject() {
        if (singletonInstance == null)
            singletonInstance = new SimpleActionRepository();

        return singletonInstance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * Initialize ActionRepository module and allocate all required resources.
     */
    public void init() {
    }
}

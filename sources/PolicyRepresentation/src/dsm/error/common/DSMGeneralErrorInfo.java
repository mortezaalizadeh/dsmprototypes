/**
 * @author Morteza Alizadeh
 */
package dsm.error.common;

import dsm.common.DSMManifest;

/**
 * DSMGeneralErrorInfo class include basic fields and attributes require to
 * demonstrate an error event.
 * 
 * @version 0.1, March 30, 2012
 * @author Morteza Alizadeh
 */
public class DSMGeneralErrorInfo extends DSMManifest {
   
    /**
     * Error message
     */
    protected String errorMessage;

    /**
     * Occurred exception
     */
    protected Exception occurredException;
    
    /**
     * DSMGeneralErrorInfo Constructor
     */
    public DSMGeneralErrorInfo() {
        super("2dfd2542-b431-4142-8abb-49770828ba8b", "DSM General Error Information");

        errorMessage = "";
        occurredException = null;
    }

    /**
     * DSMGeneralErrorInfo Constructor
     * 
     * @param szErrorMessage Error message
     */
    public DSMGeneralErrorInfo(String szErrorMessage) {
        super("2dfd2542-b431-4142-8abb-49770828ba8b", "DSM General Error Information");

        errorMessage = szErrorMessage;
        occurredException = null;
    }

    /**
     * DSMGeneralErrorInfo Constructor
     * 
     * @param exception Occurred exception
     */
    public DSMGeneralErrorInfo(Exception exception) {
        super("2dfd2542-b431-4142-8abb-49770828ba8b", "DSM General Error Information");

        errorMessage = "";
        occurredException = exception;
    }

    /**
     * DSMGeneralErrorInfo Constructor
     * 
     * @param szErrorMessage Error message
     * @param exception Occurred exception
     */
    public DSMGeneralErrorInfo(String szErrorMessage, Exception exception) {
        super("2dfd2542-b431-4142-8abb-49770828ba8b", "DSM General Error Information");

        errorMessage = szErrorMessage;
        occurredException = exception;
    }

    /**
     * Sets error message
     * 
     * @param value error message to be set
     */
    public void setErrorMessage(String value){
        errorMessage = value;
    }

    /**
     * Returns error message
     * 
     * @return Returns error message
     */
    public String getErrorMessage(){
        return errorMessage;
    }

    /**
     * Sets occurred exception
     * 
     * @param value occurred exception to be set
     */
    public void setOccurredException(Exception value){
        occurredException = value;
    }

    /**
     * Returns occurred exception
     * 
     * @return Returns occurred exception
     */
    public Exception getOccurredException(){
        return occurredException;
    }
}

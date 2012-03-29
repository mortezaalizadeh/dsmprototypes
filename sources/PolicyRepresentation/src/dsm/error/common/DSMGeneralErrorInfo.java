/**
 * @author Morteza Alizadeh
 */
package dsm.error.common;

/**
 * DSMGeneralErrorInfo class include basic fields and attributes require to
 * demonstrate an error event.
 * 
 * @version 0.1, March 30, 2012
 * @author Morteza Alizadeh
 */
public class DSMGeneralErrorInfo extends Object{
   
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
        errorMessage = "";
        occurredException = null;
    }

    /**
     * DSMGeneralErrorInfo Constructor
     * 
     * @param szErrorMessage Error message
     */
    public DSMGeneralErrorInfo(String szErrorMessage) {
        errorMessage = szErrorMessage;
        occurredException = null;
    }

    /**
     * DSMGeneralErrorInfo Constructor
     * 
     * @param exception Occurred exception
     */
    public DSMGeneralErrorInfo(Exception exception) {
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

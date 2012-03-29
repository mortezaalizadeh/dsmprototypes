/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression;

import dsm.common.DSMManifest;
import dsm.error.common.DSMGeneralErrorInfo;
import dsm.parser.expression.common.BooleanExpressionParser;
import dsm.parser.expression.common.BooleanExpressionResult;

/**
 * Simple boolean expression parser class is used to parse different boolean
 * expressions.
 * 
 * @version 0.1, March 27, 2012
 * @author Morteza Alizadeh
 */
public class SimpleBooleanExpressionParser extends DSMManifest implements BooleanExpressionParser{
    /**
     * SimpleConstraintExpressionParser Constructor
     */
    public SimpleBooleanExpressionParser() {
        super("1caa8e3c-023b-40c9-97ca-b6bed0ddfd2c", "Simple Boolean Expression Parser");
    }
    
    /**
     * Parses and evaluate expression and return true or false.
     * 
     * @param szExpression Expression to be parsed and evaluated
     * @param result Contains result of expression in return
     * @param errorInfo Contains error info if error occurs in return. To get
     * occurred error information, this parameter reference should not be null.
     * 
     * @return Returns true if evaluation is successfully done and the value is
     * returned, otherwise return false and errorInfo contains occurred error info
     */
    @Override
    public boolean parseAndEvaluateExpression(String szExpression, BooleanExpressionResult result, DSMGeneralErrorInfo errorInfo) {
        boolean bSuccess = false;
        
        try{
            do {
                if (szExpression == null) {
                    if(errorInfo != null){
                        errorInfo.setErrorMessage("Error: Passed szExpression reference is null.");
                        errorInfo.setOccurredException(null);
                    }
                    
                    break;
                }

                if ((szExpression = szExpression.trim()).length() == 0) {
                    if(errorInfo != null){
                        errorInfo.setErrorMessage("Error: Passed szExpression string length is zero.");
                        errorInfo.setOccurredException(null);
                    }
                    
                    break;
                }

                bSuccess = true;
            } while(false);
        } catch(Exception e) {
            if(errorInfo != null){
                errorInfo.setErrorMessage(e.getMessage());
                errorInfo.setOccurredException(e);
            }
        }
        
        return bSuccess;
    }
}

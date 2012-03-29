/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression.common;

import dsm.common.DSMManifest;

/**
 * BooleanExpressionResult contains the result of boolean expression evaluation.
 * 
  * @version 0.1, March 30, 2012
 * @author Morteza Alizadeh
 */
public class BooleanExpressionResult extends DSMManifest {

    /**
     * Expression evaluated result
     */
    private boolean evaluatedResult;
    
    /**
     * BooleanExpressionResult Constructor
     */
    public BooleanExpressionResult() {
        super("31d7b03a-c8e7-4132-a11f-e5fb106f92b7", "Boolean Expression Result");

        evaluatedResult = false;
    }
    
    /**
     * Sets value of evaluatedResult
     * 
     * @param value Value to be set
     */
    public void setEvaluatedResult(boolean value){
        evaluatedResult = value;
    }

    /**
     * Returns value of evaluatedResult
     * 
     * @return Returns boolean value representing current object evaluatedResult value
     */
    public boolean getEvaluatedResult(){
        return evaluatedResult;
    }
}

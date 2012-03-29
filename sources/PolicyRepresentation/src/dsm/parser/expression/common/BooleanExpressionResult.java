/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression.common;

/**
 * BooleanExpressionResult contains the result of boolean expression evaluation.
 * 
  * @version 0.1, March 30, 2012
 * @author Morteza Alizadeh
 */
public class BooleanExpressionResult {

    /**
     * Expression evaluated result
     */
    private boolean evaluatedResult;
    
    /**
     * BooleanExpressionResult Constructor
     */
    public BooleanExpressionResult() {
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
     * @return Boolean value representing current object evaluatedResult value
     */
    public boolean getEvaluatedResult(){
        return evaluatedResult;
    }
}

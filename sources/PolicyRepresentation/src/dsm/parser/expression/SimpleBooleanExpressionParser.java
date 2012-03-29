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
     * @return boolean value representing the evaluation of boolean expression
     */
    @Override
    public boolean parseAndEvaluateExpression(String szExpression, BooleanExpressionResult result, DSMGeneralErrorInfo errorInfo) {
        if(szExpression == null)
            throw new IllegalArgumentException("Error: Passed szExpression reference is NULL.");
        
        if(szExpression.length() == 0)
            throw new IllegalArgumentException("Error: Passed szExpression length is zero.");
        
        return true;
    }
}

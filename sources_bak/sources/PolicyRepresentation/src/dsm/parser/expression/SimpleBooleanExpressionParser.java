/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression;

import dsm.common.DSMManifest;
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
     */
    @Override
    public void parseAndEvaluateExpression(String szExpression, BooleanExpressionResult result) {
        if (szExpression == null)
            throw new NullPointerException("Error: Passed szExpression reference is null.");

        szExpression = szExpression.trim();

        if (szExpression.length() == 0)
            throw new IllegalArgumentException("Error: Passed szExpression string length is zero.");
    }
}

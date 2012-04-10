/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression.common;

/**
 * BooleanExpressionParser interface defines general operations and attributes
 * for a boolean expression parser.
 * 
 * This interface must be implemented by all different type of boolean
 * expression parser classes.
 * 
  * @version 0.1, March 27, 2012
 * @author Morteza Alizadeh
 */
public interface BooleanExpressionParser {
    /**
     * Parses and evaluate expression and return true or false.
     * 
     * @param szExpression Expression to be parsed and evaluated
     * @param result Contains result of expression in return
     */
    void parseAndEvaluateExpression(String szExpression, BooleanExpressionResult result);
}

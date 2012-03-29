/**
 * @author Morteza Alizadeh
 */
package dsm.parser.expression.common;

import dsm.error.common.DSMGeneralErrorInfo;

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
     * @param errorInfo Contains error info if error occurs in return. To get
     * occurred error information, this parameter reference should not be null.
     * 
     * @return Returns true if evaluation is successfully done and the value is
     * returned, otherwise return false and errorInfo contains occurred error info
     */
    boolean parseAndEvaluateExpression(String szExpression, BooleanExpressionResult result, DSMGeneralErrorInfo errorInfo);
}

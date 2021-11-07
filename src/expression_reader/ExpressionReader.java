package expression_reader;

import model.Expression;

/**
 * @author tsypk on 07.11.2021 16:36
 * @project Calculator_kata
 * Reads expression in string format
 */

public interface ExpressionReader {
    /**
     * Read expression and set fields in Expression instance
     *
     * @return read Expression
     */
    Expression read();
}

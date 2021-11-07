package exceptions;

/**
 * @author tsypk on 07.11.2021 16:27
 * @project Calculator_kata
 * Signals that format of expression incorrect
 * As example: 1++2, 1+2+3, one + two
 */

public class ExpressionFormatException extends RuntimeException {
    public ExpressionFormatException(String message) {
        super(message);
    }
}

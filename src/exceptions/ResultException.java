package exceptions;

/**
 * @author tsypk on 07.11.2021 18:50
 * @project Calculator_kata
 * Signals that result is incorrect
 * As example: negative result
 */
public class ResultException extends RuntimeException {
    public ResultException(String message) {
        super(message);
    }
}

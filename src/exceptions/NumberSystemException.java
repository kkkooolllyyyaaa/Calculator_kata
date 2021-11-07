package exceptions;

/**
 * @author tsypk on 07.11.2021 16:27
 * @project Calculator_kata
 * Signals that number systems of operands don't match each other
 */
public class NumberSystemException extends RuntimeException {
    public NumberSystemException(String message) {
        super(message);
    }

}

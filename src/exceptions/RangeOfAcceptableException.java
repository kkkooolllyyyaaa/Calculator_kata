package exceptions;

/**
 * @author tsypk on 07.11.2021 20:24
 * @project Calculator_kata
 * Signals that number greater(lower) don't fit range of acceptable
 */
public class RangeOfAcceptableException extends RuntimeException {
    public RangeOfAcceptableException() {
        super("Number don't fit range of acceptable: [1; 10]");
    }

}

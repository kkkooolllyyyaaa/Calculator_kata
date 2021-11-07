package model;

/**
 * @author tsypk on 07.11.2021 16:42
 * @project Calculator_kata
 * Operator enum, contains '+', '-', '*', '/' operators
 */
public enum Operator {
    PLUS("+"),

    MINUS("-"),

    MULTIPLICATION("*"),

    DIVISION("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator getOperatorByString(String operator) {
        for (Operator o : Operator.values()) {
            if (o.getOperator().equals(operator))
                return o;
        }
        return null;
    }
}

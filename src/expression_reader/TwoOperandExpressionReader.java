package expression_reader;

import exceptions.ExpressionFormatException;
import exceptions.NumberSystemException;
import exceptions.RangeOfAcceptableException;
import model.Expression;
import model.Operator;
import number_handler.NumberHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author tsypk on 07.11.2021 16:39
 * @project Calculator_kata
 * Class, that reads two operand expression
 */
public class TwoOperandExpressionReader implements ExpressionReader {
    private final BufferedReader reader;
    private final NumberHandler handler;

    public TwoOperandExpressionReader(NumberHandler handler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.handler = handler;
    }

    /**
     * Main method, that reads expression from standard input stream
     * @return Expression instance
     */
    @Override
    public Expression read() throws ExpressionFormatException, RangeOfAcceptableException, NumberFormatException {
        try {
            ArrayList<String> operands = getOperands();
            return process(operands);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Expression process(ArrayList<String> operands) throws RangeOfAcceptableException, ExpressionFormatException {
        Operator operator = Operator.getOperatorByString(operands.get(0));
        if (operator == null) {
            throw new ExpressionFormatException("Wrong operator");
        }
        try {
            int first = Integer.parseInt(operands.get(1));
            int second = Integer.parseInt(operands.get(2));
            Expression expression = new Expression(first, operator, second);
            expressionFitsRangeCheck(expression);
            return expression;
        } catch (NumberFormatException romanOrIncorrect) {
            Integer first = handler.handleNumber(operands.get(1));
            Integer second = handler.handleNumber(operands.get(2));
            if (first != null && second != null) {
                Expression expression = new Expression(first, operator, second);
                handler.setNumberSystem(expression);
                expressionFitsRangeCheck(expression);
                return expression;
            } else
                throw new NumberSystemException("Wrong number in number system");
        }
    }


    private ArrayList<String> getOperands() throws IOException {
        String input = reader.readLine().trim().toUpperCase();
        Pattern arabicPattern = Pattern.compile("^([0-9]+)(\\s)*[+/*-](\\s)*([0-9]+)$");
        boolean is_arabic = arabicPattern.matcher(input).find();

        Pattern romanPattern = Pattern.compile("^([VXI]+)(\\s)*[+/*\\-](\\s)*([VXI]+)$");
        boolean is_roman = romanPattern.matcher(input).find();

        if (is_arabic || is_roman) {
            return getOperandsList(input);
        } else {
            throw new ExpressionFormatException("Incorrect format of the expression");
        }
    }

    private ArrayList<String> getOperandsList(String input) {
        ArrayList<String> operands = new ArrayList<>();
        int index = getOperationIndex(input);
        operands.add("" + input.charAt(index));
        operands.add(input.substring(0, index).trim());
        operands.add(input.substring(index + 1).trim());
        return operands;
    }

    /**
     * Caller saved function
     * Caller have to check regex pattern before calling
     * Requires operator existence
     *
     * @param input input string with operator
     * @return index of the operator
     */
    private Integer getOperationIndex(String input) {
        for (int i = 0; i < input.length(); ++i) {
            String operator = "" + input.charAt(i);
            if (Operator.getOperatorByString(operator) != null) {
                return i;
            }
        }
        throw new RuntimeException("Unexpected error");
    }

    private void expressionFitsRangeCheck(Expression expression) throws RangeOfAcceptableException {
        Integer first = expression.getFirst();
        Integer second = expression.getSecond();
        if (first <= 0 || first > 10
                || second <= 0 || second > 10) {
            throw new RangeOfAcceptableException();
        }
    }
}

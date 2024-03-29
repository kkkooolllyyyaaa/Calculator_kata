package expression_printer;

import exceptions.ResultException;
import model.Expression;
import model.NumberSystem;
import number_handler.NumberHandler;

/**
 * @author tsypk on 07.11.2021 19:04
 * @project Calculator_kata
 * Class, that prints res in number system for kata academy
 */
public class ExpressionPrinterImpl implements ExpressionPrinter {
    private final NumberHandler handler;

    public ExpressionPrinterImpl(NumberHandler handler) {
        this.handler = handler;
    }

    @Override
    public void print(Expression expression) {
        if (isValidResult(expression)) {
            if (expression.getSystem().equals(NumberSystem.ARABIC)) {
                System.out.println(expression);
            } else if (expression.getSystem().equals(NumberSystem.ROMAN)) {
                System.out.println(handler.getNumberInNumberSystem(expression.getFirst()) +
                        " " +
                        expression.getOperator().getOperator() +
                        " " +
                        handler.getNumberInNumberSystem(expression.getSecond()) + " = " +
                        handler.getNumberInNumberSystem(expression.getResult())
                );
            }
        } else {
            throw new ResultException("Incorrect result");
        }
    }

    private boolean isValidResult(Expression expression) {
        if (expression.getResult() != null) {
            if (expression.getSystem().equals(NumberSystem.ROMAN)) {
                return expression.getResult() > 0;
            } else
                return true;
        } else
            return false;
    }
}

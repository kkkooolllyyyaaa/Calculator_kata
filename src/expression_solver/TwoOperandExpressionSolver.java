package expression_solver;

import model.Expression;
import model.Operator;

/**
 * @author tsypk on 07.11.2021 17:28
 * @project Calculator_kata
 */
public class TwoOperandExpressionSolver implements ExpressionSolver {
    @Override
    public void solve(Expression expression) {
        Integer res = null;
        int first = expression.getFirst(), second = expression.getSecond();
        Operator operator = expression.getOperator();
        if (operator.equals(Operator.PLUS)) {
            res = (first + second);
        } else if (operator.equals(Operator.MINUS)) {
            res = (first - second);
        } else if (operator.equals(Operator.MULTIPLICATION)) {
            res = (first * second);
        } else if (operator.equals(Operator.DIVISION)) {
            res = (first / second);
        }
        expression.setResult(res);
    }
}

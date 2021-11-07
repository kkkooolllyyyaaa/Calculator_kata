package expression_solver;

import model.Expression;

/**
 * @author tsypk on 07.11.2021 17:28
 * @project Calculator_kata
 * Solves Expression instance
 */

public interface ExpressionSolver {
    /**
     * Sets result field in expression
     *
     * @param expression expression instance
     */
    void solve(Expression expression);
}

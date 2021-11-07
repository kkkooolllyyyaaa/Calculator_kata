import expression_printer.ExpressionPrinter;
import expression_reader.ExpressionReader;
import expression_solver.ExpressionSolver;
import model.Expression;

/**
 * @author tsypk on 07.11.2021 21:12
 * @project Calculator_kata
 */
public class Calculator {
    private final ExpressionReader reader;
    private final ExpressionSolver solver;
    private final ExpressionPrinter printer;

    public Calculator(ExpressionReader reader, ExpressionSolver solver, ExpressionPrinter printer) {
        this.reader = reader;
        this.solver = solver;
        this.printer = printer;
    }

    public void calculate() {
        try {
            Expression expression = reader.read();
            solver.solve(expression);
            printer.print(expression);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

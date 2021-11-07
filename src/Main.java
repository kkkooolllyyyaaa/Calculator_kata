import expression_printer.ExpressionPrinter;
import expression_printer.ExpressionPrinterImpl;
import expression_reader.ExpressionReader;
import expression_reader.TwoOperandExpressionReader;
import expression_solver.ExpressionSolver;
import expression_solver.TwoOperandExpressionSolver;
import model.Expression;
import number_handler.NumberHandler;
import number_handler.RomanNumberHandler;

/**
 * @author tsypk on 07.11.2021 16:22
 * @project Calculator_kata
 */
public class Main {
    public static void main(String[] args) {
        try {
            NumberHandler handler = new RomanNumberHandler();
            ExpressionReader reader = new TwoOperandExpressionReader(handler);
            Expression expression = reader.read();
            ExpressionSolver solver = new TwoOperandExpressionSolver();
            solver.solve(expression);
            ExpressionPrinter printer = new ExpressionPrinterImpl(handler);
            printer.print(expression);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

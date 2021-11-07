import expression_printer.ExpressionPrinter;
import expression_printer.ExpressionPrinterImpl;
import expression_reader.ExpressionReader;
import expression_reader.TwoOperandExpressionReader;
import expression_solver.ExpressionSolver;
import expression_solver.TwoOperandExpressionSolver;
import number_handler.NumberHandler;
import number_handler.RomanNumberHandler;

/**
 * @author tsypk on 07.11.2021 16:22
 * @project Calculator_kata
 */
public class Main {
    public static void main(String[] args) {
        NumberHandler handler = new RomanNumberHandler();
        ExpressionReader reader = new TwoOperandExpressionReader(handler);
        ExpressionSolver solver = new TwoOperandExpressionSolver();
        ExpressionPrinter printer = new ExpressionPrinterImpl(handler);
        Calculator calculator = new Calculator(reader, solver, printer);
        calculator.calculate();
    }
}

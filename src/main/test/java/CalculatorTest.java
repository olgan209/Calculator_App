import org.example.calculatorapp.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        calculator.setOperand1(5);
        calculator.setOperand2(3);
        calculator.setOperator('+');
        calculator.calculate();
        assertEquals(8, calculator.getResult());
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.setOperand1(10);
        calculator.setOperand2(0);
        calculator.setOperator('/');
        calculator.calculate();
        assertTrue(calculator.isError());
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        calculator.setOperand1(4);
        calculator.setOperand2(2.5);
        calculator.setOperator('*');
        calculator.calculate();
        assertEquals(10, calculator.getResult());
    }

    @Test
    public void testClear() {
        Calculator calculator = new Calculator();
        calculator.setOperand1(10);
        calculator.setOperand2(5);
        calculator.setOperator('+');
        calculator.calculate();
        calculator.reset();
        assertEquals(0, calculator.getResult());
    }
}

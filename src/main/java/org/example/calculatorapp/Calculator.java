package org.example.calculatorapp;

public class Calculator {
    private double operand1;   // Stores the first operand
    private double operand2;   // Stores the second operand
    private char operator;     // Stores the arithmetic operator
    private double result;     // Stores the result of the operation
    private boolean isError;   // Tracks if an error occurred (e.g., division by zero)

    public void setOperand1(double operand) {
        this.operand1 = operand;
    }

    public void setOperand2(double operand) {
        this.operand2 = operand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void calculate() {
        try {
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by Zero");
                    }
                    result = operand1 / operand2;
                    break;
            }
            isError = false;
        } catch (ArithmeticException e) {
            isError = true;
        }
    }

    public double getResult() {
        return result;
    }

    public boolean isError() {
        return isError;
    }

    public void reset() {
        operand1 = 0;
        operand2 = 0;
        operator = '\0';
        result = 0;
        isError = false;
    }
}

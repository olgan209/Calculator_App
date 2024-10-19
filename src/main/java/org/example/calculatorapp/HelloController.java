package org.example.calculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField display;

    private Calculator calculator = new Calculator();
    private boolean start = true;

    @FXML
    private void handleNumber(ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (start) {
            display.setText(value);
            start = false;
        } else {
            display.setText(display.getText() + value);
        }
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!calculator.isError()) {
                calculator.setOperand1(Double.parseDouble(display.getText()));
            }
            calculator.setOperator(value.charAt(0));
            display.setText("");
        }
    }

    @FXML
    private void handleEquals(ActionEvent event) {
        calculator.setOperand2(Double.parseDouble(display.getText()));
        calculator.calculate();
        if (calculator.isError()) {
            display.setText("Error");
        } else {
            display.setText(String.valueOf(calculator.getResult()));
        }
        start = true;
    }

    @FXML
    private void handleClear(ActionEvent event) {
        calculator.reset();
        display.setText("");
        start = true;
    }
}
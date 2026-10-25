package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q7 extends JFrame implements ActionListener {
    JTextField num1Field, num2Field, resultField;

    JButton addButton, subButton;
    JButton mulButton, divButton, clearButton;

    Q7() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        add(new JLabel("First Number:"));
        num1Field = new JTextField(10);
        add(num1Field);

        add(new JLabel("Second Number:"));
        num2Field = new JTextField(10);
        add(num2Field);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clearButton = new JButton("Clear");

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(clearButton);

        add(new JLabel("Result:"));
        resultField = new JTextField(20);
        resultField.setEditable(false);
        add(resultField);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            num1Field.setText("");
            num2Field.setText("");
            resultField.setText("");
            return;
        }

        try {
            double num1 = Double.parseDouble(
                    num1Field.getText().trim());

            double num2 = Double.parseDouble(
                    num2Field.getText().trim());

            double result;

            if (e.getSource() == addButton) {
                result = num1 + num2;

            } else if (e.getSource() == subButton) {
                result = num1 - num2;

            } else if (e.getSource() == mulButton) {
                result = num1 * num2;

            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    resultField.setText(
                            "Cannot divide by zero");
                    return;
                }

                result = num1 / num2;

            } else {
                return;
            }

            resultField.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            resultField.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new Q7();
    }
}
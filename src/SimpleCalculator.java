import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;
    private String operator;
    private double firstOperand;

    public SimpleCalculator() {
        input = new StringBuilder();
        operator = "";
        firstOperand = 0;

        setTitle("Калькулятор");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание текстового поля для отображения
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C":
                input.setLength(0);
                display.setText("");
                operator = "";
                firstOperand = 0;
                break;
            case "=":
                calculateResult();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (input.length() > 0) {
                    firstOperand = Double.parseDouble(input.toString());
                    operator = command;
                    input.setLength(0);
                }
                break;
            default:
                input.append(command);
                display.setText(input.toString());
                break;
        }
    }

    private void calculateResult() {
        if (operator.isEmpty() || input.length() == 0) {
            return;
        }

        double secondOperand = Double.parseDouble(input.toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0) {
                    JOptionPane.showMessageDialog(this, "Ошибка: Деление на ноль", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = firstOperand / secondOperand;
                break;
        }

        display.setText(String.valueOf(result));
        input.setLength(0);
        operator = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}

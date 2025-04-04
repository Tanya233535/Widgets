import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorSelectorApp {
    private JFrame frame;
    private JComboBox<String> colorComboBox;
    private JButton respondButton;
    private JLabel responseLabel;
    private JCheckBox customColorCheckBox;
    private JTextField customColorField;

    public ColorSelectorApp() {
        frame = new JFrame("Color Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Создание JComboBox с цветами
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple"};
        colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox);

        respondButton = new JButton("Ответить");
        respondButton.addActionListener(new RespondButtonListener());
        frame.add(respondButton);

        responseLabel = new JLabel("Ответ: ");
        frame.add(responseLabel);

        customColorCheckBox = new JCheckBox("Ввести свой цвет");
        customColorCheckBox.addActionListener(e -> {
            customColorField.setEnabled(customColorCheckBox.isSelected());
            if (!customColorCheckBox.isSelected()) {
                customColorField.setText("");
            }
        });
        frame.add(customColorCheckBox);

        // JTextField для ввода собственного цвета
        customColorField = new JTextField(15);
        customColorField.setEnabled(false); // Изначально отключен
        frame.add(customColorField);
        
        frame.setVisible(true);
    }

    private class RespondButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedColor = (String) colorComboBox.getSelectedItem();
            if (customColorCheckBox.isSelected() && !customColorField.getText().isEmpty()) {
                selectedColor = customColorField.getText();
            }
            responseLabel.setText("Ответ: " + selectedColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorSelectorApp::new);
    }
}


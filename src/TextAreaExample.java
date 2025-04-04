import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создаем панель для размещения элементов
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Создаем JTextField для ввода текста
        JTextField textField = new JTextField();

        // Создаем JTextArea для отображения текста
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Запретим редактирование JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea); // Оборачиваем JTextArea в JScrollPane

        JButton button = new JButton("Записать");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText(); // Получаем текст из JTextField
                if (!text.isEmpty()) { // Проверяем, что текст не пустой
                    textArea.append(text + "\n"); // Добавляем текст в JTextArea
                    textField.setText(""); // Очищаем JTextField
                }
            }
        });

        panel.add(textField, BorderLayout.NORTH);
        panel.add(button, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
}

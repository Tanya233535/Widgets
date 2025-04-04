import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerApp {
    private int clickCount = 0;
    private JLabel label; // Метка для отображения количества нажатий

    public ClickerApp() {
        JFrame frame = new JFrame("Кликер");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null); // Устанавливаем абсолютное расположение

        JButton button = new JButton("Нажми меня!");
        button.setBounds(90, 50, 120, 30); // Задаем положение и размер кнопки

        label = new JLabel("Количество нажатий: 0");
        label.setBounds(70, 100, 200, 30); // Задаем положение и размер метки

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++; // Увеличиваем счетчик нажатий
                label.setText("Количество нажатий: " + clickCount); // Обновляем текст метки
            }
        });

        frame.add(button);
        frame.add(label);

        // Делаем окно видимым
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Запускаем приложение
        SwingUtilities.invokeLater(() -> new ClickerApp());
    }
}


import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Изменение шрифта надписи");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Используем BorderLayout для размещения компонентов

        JLabel label = new JLabel("Моя первая надпись!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.ITALIC, 50));
        frame.add(label, BorderLayout.CENTER);

        // Создаем слайдер для изменения размера шрифта
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 100, 50); // диапазон от 5 до 100, начальное значение 50
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Добавляем слушателя для изменения размера шрифта
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = slider.getValue(); // Получаем текущее значение слайдера
                label.setFont(new Font("Arial", Font.ITALIC, fontSize)); // Устанавливаем новый размер шрифта
            }
        });

        // Добавляем слайдер в нижнюю часть окна
        frame.add(slider, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSpinnerApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор книг для лагеря");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Создаем JSpinner для выбора количества книг
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinner = new JSpinner(model);
        frame.add(spinner);

        JButton button = new JButton("Ответить");
        frame.add(button);

        JLabel responseLabel = new JLabel("Ответ: ");
        frame.add(responseLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfBooks = (Integer) spinner.getValue(); // Получаем значение из JSpinner
                responseLabel.setText("Ответ: Вы берете " + numberOfBooks + " книг(и) с собой в лагерь.");
            }
        });

        frame.setVisible(true);
    }
}


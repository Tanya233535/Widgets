import javax.swing.*;
import java.awt.*;

public class GUIExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример GUI");

        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Моя первая надпись!", SwingConstants.CENTER);

        label.setFont(new Font("Arial", Font.ITALIC, 50));

        frame.add(label);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}

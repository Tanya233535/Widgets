import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeasonsApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор времени года");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JRadioButton springButton = new JRadioButton("Весна");
        JRadioButton summerButton = new JRadioButton("Лето");
        JRadioButton autumnButton = new JRadioButton("Осень");
        JRadioButton winterButton = new JRadioButton("Зима");

        ButtonGroup group = new ButtonGroup();
        group.add(springButton);
        group.add(summerButton);
        group.add(autumnButton);
        group.add(winterButton);

        JButton answerButton = new JButton("Ответить");

        JLabel answerLabel = new JLabel("");

        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSeason = "";
                if (springButton.isSelected()) {
                    selectedSeason = "Весна";
                } else if (summerButton.isSelected()) {
                    selectedSeason = "Лето";
                } else if (autumnButton.isSelected()) {
                    selectedSeason = "Осень";
                } else if (winterButton.isSelected()) {
                    selectedSeason = "Зима";
                }
                answerLabel.setText("Ваше любимое время года: " + selectedSeason);
            }
        });

        frame.add(springButton);
        frame.add(summerButton);
        frame.add(autumnButton);
        frame.add(winterButton);
        frame.add(answerButton);
        frame.add(answerLabel);
        
        frame.setVisible(true);
    }
}


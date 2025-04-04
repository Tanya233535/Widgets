import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp {
    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton, finishButton;
    private ButtonGroup buttonGroup;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Какой язык программирования используется для создания Android-приложений?",
            "Какой из следующих языков является языком разметки?",
            "Что такое OOP?",
            "Какой метод используется для запуска Java-программы?"
    };

    private String[][] optionsList = {
            {"Java", "C#", "Python", "JavaScript"},
            {"HTML", "C++", "Java", "Ruby"},
            {"Объектно-Ориентированное Программирование", "Объектно-Определенное Программирование", "Объектно-Ограниченное Программирование", "Операционное Программирование"},
            {"main()", "start()", "run()", "execute()"}
    };

    private int[] answers = {0, 0, 0, 0}; // Индексы правильных ответов

    public QuizApp() {
        frame = new JFrame("Викторина");
        panel = new JPanel();
        questionLabel = new JLabel();
        options = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        nextButton = new JButton("Следующий");
        finishButton = new JButton("Завершить");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(panel);

        panel.add(questionLabel);
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            buttonGroup.add(options[i]);
            panel.add(options[i]);
        }
        panel.add(nextButton);
        panel.add(finishButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup.getSelection() != null) {
                    if (buttonGroup.getSelection().getActionCommand().equals(options[answers[currentQuestionIndex]].getText())) {
                        score++;
                    }
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.length) {
                        loadQuestion();
                    } else {
                        showResult();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Пожалуйста, выберите ответ.");
                }
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showResult();
            }
        });

        loadQuestion();
        frame.setVisible(true);
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestionIndex]);
        buttonGroup.clearSelection();
        for (int i = 0; i < options.length; i++) {
            options[i].setText(optionsList[currentQuestionIndex][i]);
            options[i].setActionCommand(optionsList[currentQuestionIndex][i]);
            options[i].setSelected(false);
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(frame, "Ваш результат: " + score + " из " + questions.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuizApp());
    }
}


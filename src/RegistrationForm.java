import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JComboBox<String> eventComboBox;
    private JCheckBox termsCheckBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JTextArea commentsArea;
    private JSpinner ageSpinner;

    public RegistrationForm() {
        setTitle("Форма регистрации");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2));

        // Вопросы и виджеты
        add(new JLabel("Имя:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Электронная почта:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Выберите мероприятие:"));
        String[] events = {"Концерт", "Выставка", "Семинар", "Мастер-класс"};
        eventComboBox = new JComboBox<>(events);
        add(eventComboBox);

        add(new JLabel("Возраст:"));
        ageSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        add(ageSpinner);

        add(new JLabel("Пол:"));
        JPanel genderPanel = new JPanel();
        maleRadioButton = new JRadioButton("Мужской");
        femaleRadioButton = new JRadioButton("Женский");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);

        add(new JLabel("Комментарий:"));
        commentsArea = new JTextArea(5, 20);
        add(new JScrollPane(commentsArea));

        add(new JLabel("Согласие с условиями:"));
        termsCheckBox = new JCheckBox("Я согласен");
        add(termsCheckBox);

        JButton submitButton = new JButton("Отправить");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });
        add(submitButton);
    }

    private void submitForm() {
        String name = nameField.getText();
        String email = emailField.getText();
        String event = (String) eventComboBox.getSelectedItem();
        int age = (Integer) ageSpinner.getValue();
        String gender = maleRadioButton.isSelected() ? "Мужской" : "Женский";
        String comments = commentsArea.getText();
        boolean termsAccepted = termsCheckBox.isSelected();

        String message = String.format("Имя: %s " + "Email: %s Мероприятие: %s Возраст: %d Пол: %s Комментарий: %s Согласие: %s",
        name, email, event, age, gender, comments, termsAccepted ? "Да" : "Нет");

        JOptionPane.showMessageDialog(this, message, "Регистрация", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm form = new RegistrationForm();
            form.setVisible(true);
        });
    }
}


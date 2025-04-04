import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private String currentFilePath;

    public TextEditor() {
        setTitle("Текстовый редактор");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");

        openItem.addActionListener(new OpenAction());
        saveItem.addActionListener(new SaveAction());
        saveAsItem.addActionListener(new SaveAsAction());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private class OpenAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(TextEditor.this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                currentFilePath = file.getAbsolutePath();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.setText("");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(TextEditor.this, "Error opening file: " + ex.getMessage());
                }
            }
        }
    }

    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentFilePath != null) {
                saveFile(currentFilePath);
            } else {
                saveAsFile();
            }
        }
    }

    private class SaveAsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveAsFile();
        }
    }

    private void saveFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    }

    private void saveAsFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(TextEditor.this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            currentFilePath = file.getAbsolutePath();
            saveFile(currentFilePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}

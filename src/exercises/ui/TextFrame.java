package exercises.ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TextFrame extends JFrame {
    public TextFrame(String title, int width, int height) {
        this.setTitle(title);
        String content = readFile(title);

        JTextArea textArea = new JTextArea(content);
        this.add(textArea, BorderLayout.NORTH);

        JButton button = new JButton("Save");
        button.addActionListener(e -> {
            writeFile(title, textArea.getText());
            this.dispose();
        });
        this.add(button, BorderLayout.SOUTH);

        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                content.append(br.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            return "Error reading file " + filename;
        }

        return content.toString();
    }

    private static void writeFile(String filename, String content) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
            br.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file " + filename);
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        if (args.length != 3) {
            System.out.println("Wrong number of arguments: <title> <width> <height>");
        } else {
            new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
    }
}

package exercises.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextfileViewer extends JFrame {
    public TextfileViewer() {
        File file = getTextFile();
        String[] options = {"all", "first 10 lines"};
        boolean showAllLines = JOptionPane.showOptionDialog(
                null,
                "Show all or just first 10 lines",
                file.getName(),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]) == JOptionPane.YES_OPTION;

        if (showAllLines) viewAll(file);
        else view10lines(file);


    }



    private void viewAll(File file) {
        JFrame f = new JFrame();
        JScrollPane scrollPane = new JScrollPane();
        String content = readAll(file);
        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        f.add(scrollPane);
        scrollPane.setViewportView(textArea);
        f.setSize(800, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private void view10lines(File file) {
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(10, 1));
        String[] content = read10lines(file);
        for (int i = 0; i < content.length && content[i] != null; i++) {
            f.add(new JLabel(content[i]));
        }
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private File getTextFile() {
        JFileChooser fc = new JFileChooser();
        File file;
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);
        fc.setVisible(true);
        if (state == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile();
        } else {
            return new File("");
        }
    }

    private static String[] read10lines(File file) {
        String[] content = new String[10];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < 10 && br.ready(); i++) {
                content[i] = br.readLine();
            }
        } catch (IOException e) {
            return new String[0];
        }

        return content;
    }

    private static String readAll(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                content.append(br.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            return "Error reading file " + file;
        }

        return content.toString();
    }

    public static void main(String[] args) {
        new TextfileViewer();
    }
}

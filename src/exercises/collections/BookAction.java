package exercises.collections;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class BookAction implements ActionListener {
    private HashSet<Book> bookList;

    private JFrame parent;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField publisherField;

    public BookAction(JFrame parent, JTextField titleField, JTextField authorField, JTextField yearField, JTextField publisherField) {
        this.parent = parent;
        this.titleField = titleField;
        this.authorField = authorField;
        this.yearField = yearField;
        this.publisherField = publisherField;
        this.bookList = readBooks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            String title = titleField.getText();
            titleField.setText("");
            String author = authorField.getText();
            authorField.setText("");
            int year;
            try {
                year = Integer.parseInt(yearField.getText());
                yearField.setText("");
            } catch (NumberFormatException ex) {
                year = 0;
            }
            String publisher = publisherField.getText();
            publisherField.setText("");
            Book book = new Book(title, author, year, publisher);
            bookList.add(book);
        } else if (e.getActionCommand().equals("Title")) {
            ArrayList<Book> titleList = new ArrayList<>(bookList);
            titleList.sort(Comparator.comparing(Book::getTitle));
            showDialog(titleList);
        } else if (e.getActionCommand().equals("Author")) {
            ArrayList<Book> authorList = new ArrayList<>(bookList);
            authorList.sort(Comparator.comparing(Book::getAuthor));
            showDialog(authorList);
        } else if (e.getActionCommand().equals("Year")) {
            ArrayList<Book> yearList = new ArrayList<>(bookList);
            yearList.sort(Comparator.comparing(Book::getYear));
            showDialog(yearList);
        } else if (e.getActionCommand().equals("Publisher")) {
            ArrayList<Book> publisherList = new ArrayList<>(bookList);
            publisherList.sort(Comparator.comparing(Book::getPublisher));
            showDialog(publisherList);
        }
    }

    public void save() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("books.txt", false))) {
            StringBuilder s = new StringBuilder();
            for (Book book : this.bookList) {
                s.append(book.toString()).append("\n");
            }
            out.write(s.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HashSet<Book> readBooks() {
        HashSet<Book> books = new HashSet<Book>();
        try (BufferedReader in = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] split = line.split(";", 5);
                String title = split[0];
                String author = split[1];
                int year;
                try {
                    year = Integer.parseInt(split[2]);
                } catch (NumberFormatException e) {
                    year = 0;
                }
                String publisher = split[3];
                Book book = new Book(title, author, year, publisher);
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    private void showDialog(ArrayList<Book> books) {
        StringBuilder content = new StringBuilder();
        for (Book book : books) {
            content.append(book.displayString()).append("\n");
        }
        JOptionPane.showMessageDialog(parent, content.toString());
    }
}

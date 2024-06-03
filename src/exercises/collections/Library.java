package exercises.collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Library extends JFrame {
    private final BookAction bookAction;

    public static void main(String[] args) {
        new Library();
    }
    public Library() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Library");
        this.setLayout(new GridLayout(6, 1));
        this.setSize(500, 500);

        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new GridLayout(1, 2));
        JLabel title = new JLabel("Library");
        panelTitle.add(title);
        JTextField titleField = new JTextField();
        panelTitle.add(titleField);

        JPanel panelAuthor = new JPanel();
        panelAuthor.setLayout(new GridLayout(1, 2));
        JLabel author = new JLabel("Author");
        panelAuthor.add(author);
        JTextField authorField = new JTextField();
        panelAuthor.add(authorField);

        JPanel panelYear = new JPanel();
        panelYear.setLayout(new GridLayout(1, 2));
        JLabel year = new JLabel("Year");
        panelYear.add(year);
        JTextField yearField = new JTextField();
        panelYear.add(yearField);

        JPanel panelPublisher = new JPanel();
        panelPublisher.setLayout(new GridLayout(1, 2));
        JLabel publisher = new JLabel("Publisher");
        panelPublisher.add(publisher);
        JTextField publisherField = new JTextField();
        panelPublisher.add(publisherField);

        this.bookAction = new BookAction(this, titleField, authorField, yearField, publisherField);

        JButton buttonSave = new JButton("Save entry");
        buttonSave.addActionListener(bookAction);
        buttonSave.setActionCommand("Save");

        JPanel panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(1, 5));
        JLabel display = new JLabel("Ordered output:");
        panelDisplay.add(display);
        JButton buttonTitle = new JButton("Title");
        buttonTitle.addActionListener(bookAction);
        buttonTitle.setActionCommand("Title");
        //just for testing (above)
        panelDisplay.add(buttonTitle);
        JButton buttonAuthor = new JButton("Author");
        buttonAuthor.addActionListener(bookAction);
        buttonAuthor.setActionCommand("Author");
        panelDisplay.add(buttonAuthor);
        JButton buttonYear = new JButton("Year");
        buttonYear.addActionListener(bookAction);
        buttonYear.setActionCommand("Year");
        panelDisplay.add(buttonYear);
        JButton buttonPublish = new JButton("Publisher");
        buttonPublish.addActionListener(bookAction);
        buttonPublish.setActionCommand("Publisher");
        panelDisplay.add(buttonPublish);

        this.add(panelTitle);
        this.add(panelAuthor);
        this.add(panelYear);
        this.add(panelPublisher);
        this.add(buttonSave);
        this.add(panelDisplay);

        this.setVisible(true);
    }

    @Override
    public void dispose() {
        this.bookAction.save();
        super.dispose();
        System.exit(0);
    }
}

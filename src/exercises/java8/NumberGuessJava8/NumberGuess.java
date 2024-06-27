package exercises.java8.NumberGuessJava8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

public class NumberGuess extends JFrame {
    public static void main(String[] args) {
        new NumberGuess();
    }

    public NumberGuess() {
        this.setTitle("Number Guess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(4, 1));

        JPanel panelPlayerName = new JPanel();
        panelPlayerName.setLayout(new GridLayout(1, 2));
        JLabel playerNameLabel = new JLabel("Player Name");
        panelPlayerName.add(playerNameLabel);
        JTextField playerNameField = new JTextField();
        panelPlayerName.add(playerNameField);

        JPanel panelNumberInput = new JPanel();
        panelNumberInput.setLayout(new GridLayout(1, 2));
        JLabel numberInputLabel = new JLabel("Enter number between 1 and 1000");
        panelNumberInput.add(numberInputLabel);
        JTextField numberInputField = new JTextField();
        panelNumberInput.add(numberInputField);

        JPanel panelMenuButtons = new JPanel();
        panelMenuButtons.setLayout(new GridLayout(1, 4));
        JButton buttonNewGame = new JButton("New Game");
        JButton buttonOK = new JButton("OK");
        JButton buttonBest = new JButton("Best Player");
        JButton buttonExit = new JButton("Exit");
        panelMenuButtons.add(buttonNewGame);
        panelMenuButtons.add(buttonOK);
        panelMenuButtons.add(buttonBest);
        panelMenuButtons.add(buttonExit);
        buttonNewGame.setActionCommand("new game");
        buttonOK.setActionCommand("guess");
        buttonBest.setActionCommand("best player");
        buttonExit.setActionCommand("exit");

        buttonNewGame.addActionListener(e -> {

        });
        buttonOK.addActionListener(e -> {});
        buttonBest.addActionListener(e -> {

        });
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        JTextField textFieldOutput = new JTextField();
        textFieldOutput.setEditable(false);

        NumberGuessAction action = new NumberGuessAction(textFieldOutput, playerNameField, numberInputField);
        Stream.of(
                buttonNewGame, buttonOK, buttonBest, buttonExit
        ).forEach(
                button -> button.addActionListener(action)
        );
        Stream.of(
                panelPlayerName, panelNumberInput, panelMenuButtons, textFieldOutput
        ).forEach(this::add);

        this.setVisible(true);

    }
}

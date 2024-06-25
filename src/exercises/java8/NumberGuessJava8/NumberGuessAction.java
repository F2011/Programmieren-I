package exercises.java8.NumberGuessJava8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class NumberGuessAction extends AbstractAction implements ActionListener {

    private int numberGuesses;
    private int randomNumber;
    private JTextField textFieldOutput;
    private JTextField textFieldPlayerName;
    private JTextField textFieldGuesses;

    private static Path p = Paths.get("scores.txt");

    public NumberGuessAction(JTextField textFieldOutput, JTextField textFieldPlayerName, JTextField textFieldGuesses) {
        this.textFieldOutput = textFieldOutput;
        this.textFieldPlayerName = textFieldPlayerName;
        this.textFieldGuesses = textFieldGuesses;
        this.randomNumber = getRandom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "new game")) {
            newGame();
        } else if (Objects.equals(e.getActionCommand(), "guess")) {
            try {
                int guess = Integer.parseInt(textFieldGuesses.getText());
                if (!(guess > 0 && guess <= 1000)) {
                    throw new NumberFormatException("Fehler");
                }
                numberGuesses++;
                String text;
                if (guess == randomNumber) {
                    text = "You guessed right!";
                    writeScore(this.textFieldPlayerName.getText(), this.numberGuesses);
                    newGame();
                } else if (guess > randomNumber) {
                    text = "too big!";
                } else {
                    text = "too small!";
                }
                text = String.format("Attempt #%d (%d): %s", numberGuesses, guess, text);
                textFieldOutput.setText(text);
            } catch (NumberFormatException ex) {
                this.textFieldOutput.setText("Input a valid number between 1 and 1000");
            }
        } else if (Objects.equals(e.getActionCommand(), "best player")) {
            Score bestPlayer = getHighestScore();
            this.textFieldOutput.setText("Best player: " + bestPlayer.getName() + " (" + bestPlayer.getScore() + " guesses)");
        } else if (Objects.equals(e.getActionCommand(), "exit")) {
            System.exit(0);
        }
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }

    private void writeScore(String name, int score){
        try {
            if (name.isEmpty()) {
                System.out.println("Problem with name: " + name);
                name = "Noname";
            }
            Files.write(p, (score + "/" + name + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Could not write scores.txt" + ex.getMessage());
        }
    }

    private Score getHighestScore() {
        try {
            List<String> lines = Files.readAllLines(p);
            List<Score> scores = lines.stream()
                    .map(line -> line.split("/", 2))
                    .filter(line -> line.length == 2)
                    .map(attributes -> new Score(Integer.parseInt(attributes[0]), attributes[1]))
                    .toList();
            var minimum =  scores.stream().min(Comparator.comparingInt(Score::getScore));
            return (minimum.orElse(new Score(Integer.MAX_VALUE, "")));
        } catch (IOException ex) {
            return new Score(0, "None");
        }
    }

    private int getRandom() {
        return (int) (Math.random() * 1000) + 1;
    }

    private void newGame() {
        numberGuesses = 0;
        randomNumber = getRandom();
        System.out.println(randomNumber);
        this.textFieldOutput.setText("Type your name and your first guess!");
        this.textFieldPlayerName.setText("");
        this.textFieldGuesses.setText("");
    }
}

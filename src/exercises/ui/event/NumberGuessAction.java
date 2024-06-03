package exercises.ui.event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class NumberGuessAction extends AbstractAction implements ActionListener {

    private int numberGuesses;
    private int randomNumber;
    private JTextField textFieldOutput;
    private JTextField textFieldPlayerName;
    private JTextField textFieldGuesses;

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
                textFieldPlayerName.setText("");
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
        try (
                FileWriter bufferedWriter = new FileWriter("scores.txt", true);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)
        ) {
            if (name.isEmpty()) {
                System.out.println("Problem with name: " + name);
                name = "Noname";
            }
            printWriter.println(score + "/" + name);
        } catch (IOException ex) {
            System.out.println("Could not write scores.txt" + ex.getMessage());
        }
    }

    private Score getHighestScore() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("scores.txt"))) {
            ArrayList<Score> scores = new ArrayList<Score>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("/", 2);
                try {
                    scores.add(new Score(Integer.parseInt(split[0]), split[1]));
                } catch (NumberFormatException | IndexOutOfBoundsException ignored) {
                }
            }
            bufferedReader.close();
            if (scores.isEmpty()) {return new Score(0, "None");}
            Score max = new Score(Integer.MAX_VALUE, "");
            for (Score score : scores) {
                if (score.getScore() < max.getScore()) {
                    max = score;
                }
            }
            return max;
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

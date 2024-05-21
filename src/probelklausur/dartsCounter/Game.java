package probelklausur.dartsCounter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
    }

    public void start() {
        int recentPlayer = 0;
        Scanner sc = new Scanner(System.in);
        String[] input;
        Field[] fields;
        Visit visit;
        while (true) {
            System.out.printf("Player: %s, %d points remaining.\n%s\nEnter visit: ",
                    players[recentPlayer].getName(),
                    players[recentPlayer].getRemainingPoints(),
                    getPossibleCheckout(players[recentPlayer].getRemainingPoints()));
            input = sc.nextLine().split(" ");
            fields = new Field[input.length];
            for (int i = 0; i < input.length; i++) {
                fields[i] = board.parseField(input[i]);
            }
            visit = new Visit(fields);
            System.out.printf("Scored: %d\n=======================\n", visit.getValue());
            if (!players[recentPlayer].addVisit(visit)) {
                System.out.print("\nYou're too bad for this game!\n");
                break;
            } else if (players[recentPlayer].getRemainingPoints() == 0) {
                System.out.printf("\nGame shot and the leg, %s!\n", players[recentPlayer].getName());
                writeHighscore(players[recentPlayer].getName(), players[recentPlayer].getCountDartsThrown());
                break;
            }
            recentPlayer = (recentPlayer + 1) % players.length;
        }
    }

    private boolean writeHighscore(String name, int score) {
        String text = String.format("%s won with %d darts.\n", name, score);
        File highscoreFile = new File("highscores.txt");

        try {
            if (!highscoreFile.exists()) {
                Path testFile = Paths.get("src/probelklausur/dartsCounter/highscores.txt").toAbsolutePath();
                Files.createFile(testFile);
            }
            FileWriter fw = new FileWriter(highscoreFile, true);
            fw.write(text);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Highscore could not be written.");
        }
        return false;
    }

    private String getPossibleCheckout(int remainingPoints) {
        String noCheckout = "No possible checkout.";
        if (remainingPoints > 170) return noCheckout;

        Path checkoutsFile = Paths.get("src/probelklausur/dartsCounter/checkouts.txt").toAbsolutePath();
        String[] possibleCheckouts = new String[170];
        int counter = 0;

        try (BufferedReader fileReader = Files.newBufferedReader(checkoutsFile)) {
            possibleCheckouts = Files.readAllLines(checkoutsFile).toArray(possibleCheckouts);
        } catch (IOException ex) {
            ex.printStackTrace();
            return "No checkout data available.";
        }
        if (possibleCheckouts[remainingPoints - 1].equals("-")) return noCheckout;
        else return "Possible checkout: " + possibleCheckouts[remainingPoints - 1];
    }

    public void test() {
        System.out.println(getPossibleCheckout(170));
    }
}

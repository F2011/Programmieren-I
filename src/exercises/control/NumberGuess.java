package exercises.control;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.printf("Wie ist dein Name? ");
        String name = sc.next();
        numberGuess(sc, name);
        System.out.println("Was möchtest du tun?\n0 - Das Spiel beenden\n1 - Das Spiel fortsetzen");
        while (true) {
            if (sc.nextInt() == 1) {
                numberGuess(sc, name);
            } else {
                break;
            }
        }
    }

    private static void numberGuess(Scanner sc, String name) {
        int r = (int) (Math.random() * 100 + 1);
        int guess;
        int counter = 1;
        String message;
        do {
            System.out.printf("%s, rate eine Zahl [1-100]: ", name);
            guess = sc.nextInt();
            counter++;
            message = (guess == r ? "korrekt" : (guess > r ? "zu hoch" : "zu niedrig"));
            System.out.printf("Versuch %d: %d ist %s.\n", counter, guess, message);
        } while (guess != r);
    }
}

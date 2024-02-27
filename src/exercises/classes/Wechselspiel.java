package exercises.classes;

import java.util.Scanner;

public class Wechselspiel {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        var spielfeld = new Spielfeld(9, 7);
        System.out.println(spielfeld);
        var sc = new Scanner(System.in);
        System.out.print("Player 1 begins.");
        int row1, column1, row2, column2;
        while (true) {
            System.out.print("Choose 2 fields to swap (e.g. A1B1): ");
            String input = sc.next("[A-Z][0-9][A-Z][0-9]");
            row1 = input.charAt(0) - 65;
            column1 = input.charAt(1) - 49;
            row2 = input.charAt(2) - 65;
            column2 = input.charAt(3) - 49;
            System.out.println(spielfeld.swap(row1, column1, row2, column2));
            System.out.println(spielfeld);
        }
    }
}

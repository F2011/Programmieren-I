package exercises.control;

import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int sum = 0;
        int input = 0;
        do {
            sum += input;
            System.out.printf("Zahl eingeben (<0 für Abbruch): ");
            input = sc.nextInt();
        } while (input >= 0);
        System.out.println("Summe: " + sum);
    }
}

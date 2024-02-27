package exercises.strings;

import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        int number = sc.nextInt();
        System.out.printf("Die Quersumme von %d ist %d\n", number, getDigitSum(number));
    }

    private static int getDigitSum(int n) {
        int digitSum = 0;
        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }
        return digitSum;
    }
}

package exercises.strings;

import java.util.HashMap;
import java.util.Scanner;

public class RomanNumber {
    private static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine röm. Zahl ein: ");
        String x = sc.next();
        System.out.printf("Der Wert der Zahl %s ist %d\n", x, getRomanNumber(x));
    }

    private static int getRomanNumber(String x) {
        int n = 0;
        char[] literals = x.toCharArray();
        int[] numbers = new int[x.length()];
        for (int i = 0; i < literals.length; i++) {
            numbers[i] = map.get(literals[i]);
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] >= numbers[i + 1]) n += numbers[i];
            else n -= numbers[i];
        }
        n += numbers[numbers.length - 1];

        return n;
    }
}

package exercises.arrays;

import java.util.Random;

public class StandardDeviation {
    public static void main(String[] args) {
        var r = new Random();
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(0, 11);
        }
        System.out.println("Mittelwert: " + arithmeticMiddle(a));
        System.out.println("Standardabweichung: " + standardDeviation(a));
    }

    public static double standardDeviation(int[] a) {
        double sum = 0.0;
        double m = arithmeticMiddle(a);
        for (int i : a) {
            sum += Math.pow(i - m, 2);
        }
        return Math.sqrt(sum/a.length);
    }

    public static double arithmeticMiddle(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return (1.0 * sum)/a.length;
    }
}

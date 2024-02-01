package exercises.control;

import java.util.Scanner;

public class Babylon {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        int a = sc.nextInt();

        double n0 = 1.0;
        double n1 = nextBabylon(a, n0);
        double temp;
        while (Math.abs(n1 - n0) > Math.pow(10, -6)) {
            System.out.printf("xn: %f\n", n1);
            n1 = nextBabylon(a, n1);
        }
    }

    private static double nextBabylon(int a, double x) {
        return (x + (a/x))/2;
    }
}

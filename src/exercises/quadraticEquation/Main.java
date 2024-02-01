package exercises.quadraticEquation;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("f(x) = axˆ2 + bx + c\n");
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        System.out.print("c = ");
        double c = sc.nextDouble();

        quadraticEquation(a, b, c);
    }

    public static void quadraticEquation(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("Die Gleichung ist degeneriert.");
            } else {
                double x = -(c / b);
                System.out.printf("x = %f\n", x);
            }
        } else {
            double d = Math.pow(b, 2) - 4*a*c;
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2*a);
                double x2 = (-b - Math.sqrt(d)) / (2*a);
                System.out.printf("x1 = %f\nx2 = %f\n", x1, x2);
            } else if (d == 0) {
                double x = -b / 2*a;
                System.out.printf("x = %f\n", x);
            } else {
                System.out.println("Die Lösung ist konjugiert komplex.");
            }
        }
    }
}

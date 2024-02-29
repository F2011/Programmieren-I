package exercises.methods;

public class Exponentiation {
    public static double xPowerN(double x, int n) {
        if (n == 1) return n;
        return x * xPowerN(x, n - 1);
    }
}

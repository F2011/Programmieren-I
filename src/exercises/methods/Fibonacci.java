package exercises.methods;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(fibonacci(i));
        }
    }
    public static long fibonacci(long n) {
        return fibonacciR(n)[1];
    }

    public static long[] fibonacciR(long n) {
        if (n == 0) return new long[]{0, 0};
        if (n == 1) return new long[]{0, 1};
        long[] fibs = fibonacciR(n - 1);
        return new long[]{fibs[1], fibs[0] + fibs[1]};

    }
}

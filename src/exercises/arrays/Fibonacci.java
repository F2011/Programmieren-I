package exercises.arrays;

public class Fibonacci {
    public static void main(String[] args) {
        BubbleSort.out(fibonacci(20));
    }

    public static int[] fibonacci(int n) {
        if (n < 1) return new int[]{};
        else if (n == 1) return new int[]{0};
        int[] a = new int[n];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < a.length; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a;
    }
}

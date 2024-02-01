package exercises.arrays;

public class DotProduct {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 4, 4};
        System.out.println(dotProduct(a, b));

    }

    public static double dotProduct(int[] a, int[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}

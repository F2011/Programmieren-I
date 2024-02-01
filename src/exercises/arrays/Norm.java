package exercises.arrays;

public class Norm {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(norm(a));

    }

    public static double norm(int[] a) {
        double sum = 0.0;
        for (int i : a) {
            sum += Math.pow(i, 2);
        }
        return Math.sqrt(sum);
    }
}

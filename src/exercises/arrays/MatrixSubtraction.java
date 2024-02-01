package exercises.arrays;

public class MatrixSubtraction {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {47, 29, 73,  2},
                {67, 42, 93,  9},
                { 6,  4, 36, 43},
                {70, 57, 18, 43}};
        int[][] b = new int[][]{
                {90, 58, 97, 96},
                { 6, 60,  0, 46},
                {46, 11, 55, 96},
                {33, 95, 71,  7}};
        out(matrixSubtraction(a, b));

    }

    public static int[][] matrixSubtraction(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a[0].length];
        for (int i1 = 0; i1 < a.length; i1++) {
            for (int i2 = 0; i2 < a[i1].length; i2++) {
                c[i1][i2] = a[i1][i2] - b[i1][i2];
            }
        }
        return c;
    }

    public static void out(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.printf("%3d  ", anInt);
            }
            System.out.println();
        }
    }
}

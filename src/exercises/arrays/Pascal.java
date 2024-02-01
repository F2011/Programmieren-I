package exercises.arrays;

public class Pascal {
    public static void main(String[] args) {
        out(pascal(13));
    }

    public static int[][] pascal(int n) {
        int[][] p = new int[n][2 * n - 1];
        for (int i1 = 0; i1 < p.length; i1++) {
            p[i1][p[i1].length / 2 - i1] = 1;
            p[i1][p[i1].length / 2 + i1] = 1;
            for (int i2 = (p[i1].length / 2 - i1) + 2; i2 < p[i1].length / 2 + i1; i2 += 2) {
                p[i1][i2] = p[i1 - 1][i2 - 1] + p[i1 - 1][i2 + 1];
            }
        }

        return p;
    }

    public static void out(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                if (anInt != 0) System.out.printf("%3d", anInt);
                else System.out.print("   ");
            }
            System.out.println();
        }
    }
}

package exercises.arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5, 6, 4, 6, 3, 2, 6, 1, 7, 79, 294, 0, 2, 7};
        out(a);
        bubbleSort(a);
        out(a);
    }

    public static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void out(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}

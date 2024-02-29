package exercises.methods;

import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] A = {6, 1, 9, 2, 0, 5, 7, 8, 4, 3};
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
        quickSort(A);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length);
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start == end) return;
        int pivot = start + (int) (Math.random() * (end - start));
        int recent = start;
        swap(A, end - 1, pivot);
        pivot = end - 1;
        for (int i = start; i < end - 1; i++) {
            if (A[i] < A[pivot]) {
                swap(A, i, recent);
                recent++;
            }
        }
        swap(A, pivot, recent);
        quickSort(A, start, recent);
        quickSort(A, recent + 1, end);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}

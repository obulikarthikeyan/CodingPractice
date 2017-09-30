package sort;

import java.util.Arrays;

/**
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 * insertionSort(arr, n)
 * Loop from i = 1 to n-1.
 * ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
 *
 * Time Complexity: O(n*n)
 * Auxiliary Space: O(1)
 */

public class InsertionSort {

    public static void insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++) {
            int j = i - 1;
            int k = a[i];

            while (j >= 0 && a[j] > k) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = k;
        }
    }

    public static void main(String ...args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(a));
    }
}

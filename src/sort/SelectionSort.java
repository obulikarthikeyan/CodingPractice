package sort;

import java.util.Arrays;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning.
 * The algorithm maintains two subarrays in a given array.
 *
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.

 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 *
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */

public class SelectionSort {

    public static void selectionSort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n-1; i++) {

            int min_index = i;
            for(int j = i+1; j < n; j++) {
                if(a[j] < a[min_index]) {
                    min_index = j;
                }
            }

            int temp = a[min_index];
            a[min_index] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String ...args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        selectionSort(a);
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(a));
    }
}

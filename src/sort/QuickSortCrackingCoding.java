package sort;

import java.util.Arrays;

/**
 * QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 *
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 *
 * The below program uses middle element as pivot
 */

public class QuickSortCrackingCoding {

    public static void quickSort(int[] a, int left, int right) {
        int pivotIndex = partition(a, left, right);

        if(left < pivotIndex - 1) {
            quickSort(a, left, pivotIndex - 1);
        }

        if(pivotIndex < right) {
            quickSort(a, pivotIndex, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[(left + right) / 2];
        while (left <= right) {
            while (a[left] < pivot) {
                left++;
            }
            while (a[right] > pivot) {
                right--;
            }
            if(left <= right) {
                QuickSort.swap(a, left++, right--);
            }
        }
        return left;
    }

    public static void main(String ...args) {
        System.out.print("Unsorted Array ");
        int[] a ={10, 7, 8, 9, 7, 1, 5};
        System.out.println(Arrays.toString(a));
        int n = a.length;

        quickSort(a, 0, n-1);
        System.out.print("\nSorted Array  ");
        System.out.print(Arrays.toString(a));
    }
}

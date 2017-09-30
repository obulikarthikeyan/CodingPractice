package sort;

import java.util.Arrays;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Used in Computer graphics to detect very small error.
 */

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            int count = 0;
            for(int j = 0; j < n-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    public static void bubbleSortRecursive(int[] a, int n) {
        if(n == 1) {
            return;
        }

        for(int i = 0; i < n-1; i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        bubbleSortRecursive(a, n-1);
    }

    public static void main(String ...args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        bubbleSortRecursive(a, a.length);
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(a));
    }

}

package sort;

import java.util.Arrays;

/**
 * Merge Sort is a Divide and Conquer algorithm.
 * It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves.
 * The merge() function is used for merging two halves.
 * The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one
 *
 * T: O(N log N) average and worst case. S: O(N) worst case
 *
 */

public class MergeSortCrackingCoding {

    public static void sort(int[] a, int[] temp, int l, int h) {
        if(l < h) {
            int m = (l + h)/2;

            sort(a, temp, l, m);
            sort(a, temp, m+1, h);

            merge(a, temp, l, m, h);
        }
    }

    private static void merge(int[] a, int[] temp, int l, int m, int h) {
        for (int i=l; i<=h; i++) {
            temp[i] = a[i];
        }

        int L = l;
        int M = m+1;
        int K = l;

        while (L <= m && M <= h) {
            if(temp[L] <= temp[M]) {
                a[K] = temp[L++];
            } else {
                a[K] = temp[M++];
            }
            K++;
        }

        int remaining = m - L;
        for(int i=0; i<=remaining; i++) {
            a[K + i] = temp[L + i];
        }
    }

    public static void main(String ...args) {
        int[] a = {1, 20, 6, 4, 5};
        int[] temp = new int[a.length];
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        sort(a, temp, 0, a.length -1);
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(a));
    }
}

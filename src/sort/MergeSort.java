package sort;

import java.util.Arrays;

/**
 *  Merge Sort is a Divide and Conquer algorithm.
 *  It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves.
 *  The merge() function is used for merging two halves.
 *  The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one
 *
 *  T: O(N log N) average and worst case. S: O(N) worst case
 */

public class MergeSort {

    public static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        for(int i=0; i<n1; i++) {
            temp1[i] = a[l + i];
        }

        for (int i=0; i<n2; i++) {
            temp2[i] = a[i + m + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (temp1[i] <= temp2[j]) {
                a[k] = temp1[i++];
            } else {
                a[k] = temp2[j++];
            }
            k++;
        }

        while (i < n1) {
            a[k++] = temp1[i++];
        }

        while (j < n2) {
            a[k++] = temp2[j++];
        }
    }

    public static void sort(int[] a, int l, int r) {
       if(l < r) {
           int m = (l + r)/2;

           sort(a, l, m);
           sort(a, m+1, r);

           merge(a, l, m, r);
       }
    }

    public static void main(String ...args) {
        int[] a = {1, 20, 6, 4, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length -1);
        System.out.println("\nSorted array");
        System.out.println(Arrays.toString(a));
    }
}

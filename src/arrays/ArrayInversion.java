package arrays;

import java.util.Arrays;

/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0.
 * If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

 * Example:
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 *
 * T(n) = O(nlogn)
 */

public class ArrayInversion {

    public static int divide(int[] a, int l, int r) {
        int count = 0;
        if(l < r) {
            int m = (l + r) / 2;
            count = divide(a, l, m);
            count += divide(a, m+1, r);

            count += merge(a, l, m, r);
        }
        return count;
    }

    private static int merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int count = 0;
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        for(int i=0; i<n1; i++) {
            temp1[i] = a[l + i];
        }
        for (int j=0; j<n2; j++) {
            temp2[j] = a[m + j + 1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if(temp1[i] <= temp2[j]) {
                a[k] = temp1[i];
                i++;
            } else {
                a[k] = temp2[j];
                count += (m - i) + 1;
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = temp1[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = temp2[j];
            j++;
            k++;
        }
        return count;
    }

    public static int countArrayInversion(int[] a) {
        if (a == null || a.length <= 1) {
            return 0;
        }

        return divide(a, 0, a.length - 1);
    }

    public static void main(String ...args) {
        int[] a = {2, 4, 1, 3, 5};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        System.out.println("\nNumber of Inversions = " + countArrayInversion(a));
    }
}

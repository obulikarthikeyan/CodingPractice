package arrays;

import java.util.Arrays;

/**
 * Given two sorted arrays, find their union and intersection.
 *
 * Example:
 *
 * Input:
 * arr1[] = {1, 3, 4, 5, 7}
 * arr2[] = {2, 3, 5, 6}
 *
 * Output:
 * Union : {1, 2, 3, 4, 5, 6, 7}
 * Intersection : {3, 5}
 */
public class UnionAndIntersectionOfTwoSortedArrays {

    //T: O(M + N)
    public static int[] union(int[] a, int[] b) {
        if(a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }

        int m = a.length;
        int n = b.length;

        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if(a[i] < b[j]) {
                result[k] = a[i++];
            } else if(a[i] > b[j]) {
                result[k] = b[j++];
            } else {
                result[k] = a[i];
                i++;
                j++;
            }
            k++;
        }

        while (i < m) {
            result[k++] = a[i++];
        }

        while (j < n) {
            result[k++] = b[j++];
        }
        return result;
    }

    public static void intersection(int[] a, int[] b) {
        if(a == null || a.length == 0) {
            return;
        }

        if (b == null || b.length == 0) {
            return;
        }

        int m = a.length;
        int n = b.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if(a[i] < b[j]) {
                i++;
            } else if(a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + ", ");
                i++;
                j++;
            }
        }
    }

    //T: O(min(M log N, N log M))
    public static void intersectionOptimized(int[] a, int[] b) {
        if(a == null || a.length == 0) {
            System.out.println(Arrays.toString(b));
            return;
        }

        if (b == null || b.length == 0) {
            System.out.println(Arrays.toString(a));
            return;
        }

        int[] shortest = a;
        int[] largest = b;

        if(a.length > b.length) {
            shortest = b;
            largest = a;
        }

        int m = shortest.length;
        int n = largest.length;

        for(int i = 0; i < m; i++) {
            if(binarySearch(largest, 0, n-1, shortest[i]) != -1) {
                System.out.print(shortest[i] + ", ");
            }
        }

    }

    public static int binarySearch(int[] a, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r)/2;

            if(a[mid] == x) {
                return mid;
            }

            if (a[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String ...args) {
        int[] a = {1, 3, 4, 5, 6, 7};
        int[] b = {2, 3, 5, 6, 7};

        System.out.println("Union = " + Arrays.toString(union(a, b)));
        System.out.print("\nIntersection = ");
        intersection(a, b);
        System.out.print("\nIntersection optimized = ");
        intersectionOptimized(a, b);
    }
}

package sort;

import java.util.Arrays;

/**
 * In binary search, look for an element x in a sorted array by comparing x to element in midpoint
 * If x is less, search left half of the array
 * If x is greater, search right half of the array
 *
 * Repeat the process until x is found or subarray has size 0
 *
 */

public class BinarySearch {

    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if(a[mid] < x) {
                low = mid + 1;
            } else if(a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if(a[mid] < x) {
            return binarySearchRecursive(a, x, mid+1, high);
        } else if(a[mid] > x){
            return binarySearchRecursive(a, x, low, mid-1);
        } else {
            return mid;
        }
    }

    public static void main(String ...args) {
        int[] a = {1, 2, 4, 6, 9, 10};
        int x1 = 9;
        int x2 = 2;
        System.out.println("Input: " + Arrays.toString(a) + " x1 = " + x1 + " x2 = " + x2);
        System.out.println("\nOutput: x1 = " + binarySearch(a, x1) + " x2 = " + binarySearch(a, x2));
        System.out.println("\nOutput: x1 = " + binarySearchRecursive(a, x1, 0, a.length-1) + " x2 = " + binarySearchRecursive(a, x2, 0, a.length-1));
    }
}

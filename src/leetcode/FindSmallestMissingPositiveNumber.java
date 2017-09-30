package leetcode;

/**
 * You are given an unsorted array with both positive and negative elements.
 * You have to find the smallest positive number missing from the array in O(n) time using constant extra space.
 * You can modify the original array.
 * Examples
 *
 * Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 * Output: 1
 *
 * Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 * Output: 4
 *
 * Input: {1, 1, 0, -1, -2}
 * Output: 2
 */
public class FindSmallestMissingPositiveNumber {

    //Test Case Failure
    public static int findMissingSmallestPositiveNumber(int[] a) {
        int smallest = 0;
        int n = a.length;

        for (int i = 0; i<n; i++) {
            if(a[i] != i + 1) {
                smallest = i;
                break;
            }
        }

        for (int j = smallest + 1; j < n; j++) {
            if(a[j] == smallest + 1) {
                int temp = a[smallest];
                a[smallest] = a[j];
                a[j] = temp;
                j--;
                smallest++;
            }
        }
        return smallest + 1;
    }

    public static int findLowestMissingPositiveNumber(int[] a) {
        int n = a.length;

        //move all negative integers to left side of the array
        int j = 0;
        for(int i=0; i<n; i++) {
            if(a[i] <= 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }

        for (int i=j; i<n; i++) {
            if(Math.abs(a[i]) <= n-j && a[Math.abs(a[i]) + j - 1] > 0) {
                a[Math.abs(a[i]) + j - 1] = -a[Math.abs(a[i]) + j - 1];
            }
        }

        for (int i = j; i < n; i++) {
            if(a[Math.abs(i)] > 0) {
                return i - j + 1;
            }
        }
        return j + 1;
    }

    public static void main(String ...args) {
        int[] a = {0, 2, 3, 1, -1, -2};
        System.out.println("Smallest missing positive number = " + findMissingSmallestPositiveNumber(a));
        int[] b = {1, 1, 0, -1, -2};
        System.out.println("Smallest missing positive number = " + findLowestMissingPositiveNumber(b));
    }

}

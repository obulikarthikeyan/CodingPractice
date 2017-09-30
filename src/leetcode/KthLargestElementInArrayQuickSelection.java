package leetcode;

import java.util.Arrays;

/**
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the unsorted order, not the kth distinct element.
 *
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * The basic idea is to use Quick Select algorithm to partition the array with pivot:
 *
 * Put numbers < pivot to pivot's left
 * Put numbers > pivot to pivot's right
 *
 * Then
 *
 * if indexOfPivot == k, return A[k]
 * else if indexOfPivot < k, keep checking left part to pivot
 * else if indexOfPivot > k, keep checking right part to pivot
 * Time complexity = O(n)
 * Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.
 */

public class KthLargestElementInArrayQuickSelection {

    public static int findKthLargestElement(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        return findKthLargestElement(nums, 0, nums.length - 1, nums.length - k);
    }

//    public static int findKthLargestElement(int[] nums, int start, int end, int k) {
//        int left = start;
//        int pivot = nums[end];
//        int i = left;
//        while (left < end) {
//            if(nums[i] <= pivot) {
//                swap(nums, left++, i);
//            }
//            i++;
//        }
//        swap(nums, left, end);
//    }

    //T: O(N)
    public static int findKthLargestElement(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargestElement(nums, left + 1, end, k);
        else // Check left part
            return findKthLargestElement(nums, start, left - 1, k);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String ...args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 4;
        System.out.println("Input: " + Arrays.toString(nums) + " k = " + k);
        System.out.println("\nOutput " + findKthLargestElement(nums, k));
    }
}

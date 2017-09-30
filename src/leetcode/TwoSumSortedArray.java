package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * Binary Search approach
 */

public class TwoSumSortedArray {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) {
            return result;
        }

        int i = 0;
        int j = numbers.length - 1;

        while(i<j) {
            int sum = numbers[i] + numbers[j];
            if(sum < target) {
                i++;
            } else if(sum > target) {
                j--;
            } else {
                result[0] = ++i;
                result[1] = ++j;
                break;
            }
        }
        return result;
    }

    public static void main(String ...args) {
        int[] nums = {1, 2, 3, 4, 7, 11, 12, 15};
        int target = 9;
        System.out.println("Input\n" + Arrays.toString(nums));
        System.out.println("\nTarget: " + target);
        System.out.println("\nOutput: " + Arrays.toString(twoSum(nums, target)));
    }
}

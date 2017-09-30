package leetcode;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 */

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static int[] productExceptSelfSpaceN(int[] nums) {
        int[] result = new int[nums.length];
        int[] temp = new int[nums.length];

        Arrays.fill(temp, 1);

        for(int i=1; i<nums.length; i++) {
            temp[i] = nums[i-1] * temp[i-1];
        }

        int t = 1;
        for(int i=nums.length-1; i >= 0; i--) {
            result[i] = temp[i] * t;
            t *= nums[i];
        }
        return result;
    }

    public static void main(String ...args){
        int[] nums = {1,2,3,4};
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums)));
        System.out.println("Output: " + Arrays.toString(productExceptSelfSpaceN(nums)));
    }
}

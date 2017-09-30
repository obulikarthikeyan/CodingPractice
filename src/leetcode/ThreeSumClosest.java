package leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

    public static int threeSumClosestN3Approach(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return target;
        }

        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        int result;
        int minDist = result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
           for(int j=i+1; j<nums.length-1; j++) {
               for (int k=j+1; k<nums.length; k++) {
                   int sum = nums[i] + nums[j] + nums[k];
                   int dist = Math.abs(sum - target);
                   if(dist < minDist) {
                       minDist = dist;
                       result = sum;
                   }
               }
           }
        }
        return result;
    }

    public static int threeSumClosestN2Approach(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return target;
        }

        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);

        int result = 0;
        int minDist = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                int dist = Math.abs(sum - target);
                if(dist < minDist) {
                    minDist = dist;
                    result = sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String ...args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println("closest sum O(n^3) = " + threeSumClosestN3Approach(nums, -10));
        System.out.println("closest sum O(n^2) = " + threeSumClosestN2Approach(nums, -10));
    }
}

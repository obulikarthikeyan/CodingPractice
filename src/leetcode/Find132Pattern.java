package leetcode;

import java.util.Stack;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 * Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 *
 * Output: False
 *
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 *
 * Output: True
 *
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 *
 * Output: True
 *
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Find132Pattern {

    public static boolean find132PatternN3(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (nums[i] < nums[k] && nums[j] > nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean find132PatternN1(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int  k = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static boolean find132PatternN2(int[] nums) {
        int n = nums.length;

        int min_i = Integer.MAX_VALUE;

        for (int j=0; j<n-1; j++) {
            if(nums[j] < min_i) {
                min_i = nums[j];
            }

            for (int k = j+1; k<n; k++) {
                if (nums[k] < nums[j] && min_i < nums[k]) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String ...args) {
        int[] nums = {-1, 3, 2, 0};
        System.out.println("O(N^3) " + find132PatternN3(nums));
        System.out.println("O(N^2) " + find132PatternN2(nums));
        System.out.println("O(N) " + find132PatternN1(nums));
    }
}

package leetcode;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * Image: https://leetcode.com/problems/trapping-rain-water/description/
 */

public class TrappingWater {

    private static int waterTrapped(int[] a) {
        int n = a.length;
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];

        int max = a[0];
        for(int i=0; i<n; i++) {
            if(a[i] < max) {
                leftMaxHeight[i] = max;
            } else {
                max = a[i];
                leftMaxHeight[i] = max;
            }
        }

        max = a[n-1];
        for(int i=n-1; i>=0; i--) {
            if(a[i] < max) {
                rightMaxHeight[i] = max;
            } else {
                max = a[i];
                rightMaxHeight[i] = max;
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            result += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - a[i];
        }
        return result;
    }

    public static void main(String ...args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Input:\n" + Arrays.toString(a));
        int r = waterTrapped(a);
        System.out.println("\nOutput: " + r);
    }
}

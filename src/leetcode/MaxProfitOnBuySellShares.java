package leetcode;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1
 *
 * Input: [7, 1, 5, 3, 6, 4]
 * Output:
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price
 *
 * Example 2
 *
 * Input: [7, 6, 4, 3, 1]
 * Output:
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 */

public class MaxProfitOnBuySellShares {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int min = prices[0];
        for(int i=0; i<n; i++) {
            if(prices[i] > min) {
                left[i] = min;
            } else {
                min = prices[i];
                left[i] = min;
            }
        }

        int max = prices[n-1];
        for(int i=n-1; i >= 0; i--) {
            if(prices[i] < max) {
                right[i] = max;
            } else {
                max = prices[i];
                right[i] = max;
            }
        }

        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit, right[i] - left[i]);
        }
        return maxProfit;
    }

    public static int maxProfitsSimple(int[] prices) {
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < minProfit) {
                minProfit = prices[i];
            } else if(prices[i] > minProfit) {
                maxProfit = Math.max(maxProfit, prices[i] - minProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String ...args) {
        int[] prices = {2, 1, 5, 8, 6, 4};
        System.out.println("Input: " + Arrays.toString(prices));
        System.out.println("\nOutput: " + maxProfit(prices));
        System.out.println("\nOutput: " + maxProfitsSimple(prices));
    }
}

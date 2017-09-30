package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem
 *
 * Sample Input
 *
 * 6 3
 * 5 1
 * 2 1
 * 1 1
 * 8 1
 * 10 0
 * 5 0
 *
 * Sample Output
 *
 * 29
 *
 * Explanation
 *
 * There are N = 6 contests. Of these contests, 4 are important (so she cannot lose any more than 3 of them).
 * Lena maximizes her luck if she wins the 3rd important contest (where Li is 1 )
 * and loses all of the other five contests for a total luck balance of 5+2+8+10+5-1 = 29.
 */
public class LuckBalance {

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        if(n > 0) {
            int k = scanner.nextInt();
            int[] importantLuck = new int[n];
            int luckBalance = 0;
            for (int i = 0; i<n; i++) {
                int luck = scanner.nextInt();
                int importance = scanner.nextInt();
                if (importance == 1) {
                    importantLuck[i] = luck;
                } else {
                    luckBalance += luck;
                }
            }

            Arrays.sort(importantLuck);

            int numCanLoseContests = importantLuck.length - k;
            for (int i=0; i<numCanLoseContests; i++) {
                importantLuck[i] = -importantLuck[i];
            }

            for (int i=0; i<importantLuck.length; i++) {
                luckBalance += importantLuck[i];
            }
            System.out.println(luckBalance);
        }
    }
}

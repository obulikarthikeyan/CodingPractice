package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-pairs/problem
 *
 * A pair considered beautiful if elements in A are equal and in same position as in B.
 * Change only 1 element in B. Print the maximum pairwise disjoint beautiful pairs set that can be formed.
 *
 * Input:
 *
 * 3
 * 1 2 2
 * 1 2 3
 *
 * Output:
 *
 * 3 [(0,0), (1,2), (2,1)] or [(0,0), (1,1), (2,2)]
 *
 */
public class BeautifulPairs {

    public static void main(String ...args) {
        int max_n = 1000;
        int[] count = new int[max_n + 1];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n > 0) {
            for (int i=0; i<n; i++) {
                int a = scanner.nextInt();
                count[a]++;
            }

            int beautifulPairs = 0;

            for (int i=0; i<n; i++) {
                int b = scanner.nextInt();
                if (count[b] > 0) {
                    count[b]--;
                    beautifulPairs++;
                }
            }

            if (beautifulPairs == n) {
                beautifulPairs--;
            } else {
                beautifulPairs++;
            }

            System.out.println(beautifulPairs);
        }

    }
}

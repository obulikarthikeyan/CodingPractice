package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a squared sized grid  of size  in which each cell has a lowercase letter.
 * Denote the character in the th row and in the th column as .
 *
 * You can perform one operation as many times as you like: Swap two column adjacent characters in the same row  and  for all valid .
 *
 * Is it possible to rearrange the grid such that the following condition is true?
 *
 * G[i][1] <= G[i][2] <= G[i][3] .... <= G[i][N] for 1 <= i <= N  and
 * G[1][j] <= G[2][j] <= G[3][j] .... <= G[N][j] for 1 <= j <= N
 *
 * In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?
 *
 * Note: c1 <= c2, if letter c1 is equal to c2 or is before c2 in the alphabet.
 *
 * Input Format
 *
 * The first line begins with T, the number of testcases. In each testcase you will be given . The following N lines contain N lowercase english alphabet each, describing the grid.
 *
 * Output format: Print T lines. On the ith line print YES if it is possible to rearrange the grid in the ith testcase or NO otherwise.
 *
 * Sample Input
 *   1
 *   5
 *   ebacd
 *   fghij
 *   olmkn
 *   trpqs
 *   xywuv
 *
 * Sample Output
 *
 * YES
 *
 * Explanation
 *
 * The grid in the first and only testcase can be reordered to
 *
 *   abcde
 *   fghij
 *   klmno
 *   pqrst
 *   uvwxy
 *   This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.
 */
public class GridChallenge {

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if(t > 0) {
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                char[][] m = new char[n][n];

                for (int k=0; k < n; k++) {
                    String s = scanner.next();
                    if(s.length() != n) {
                        break;
                    }

                    for (int j=0; j<n; j++) {
                        m[k][j] = s.charAt(j);
                    }
                }

                System.out.println(canRearrangeGrid(m) ? "YES" : "NO");
            }
        }


    }

    private static boolean canRearrangeGrid(char[][] m) {
        int n = m.length;
        for (int i=0; i<n; i++) {
            Arrays.sort(m[i]);
        }

        printMatrix(m);

        for (int i=0; i<n; i++)
        for (int j=0; j<n-1; j++) {
            if(m[j][i] > m[j+1][i]) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(char[][] m) {
        for (int i=0; i<m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}

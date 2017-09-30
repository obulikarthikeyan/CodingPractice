package arrays;

import java.util.Arrays;

/**
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Hint: m[i][j] = m[n-1-j][i]
 *
 * Example:
 *
 * INPUT    >>     OUTPUT    |         INPUT    >>  OUTPUT

 * 1 2 3 4        1 1 1 1      |     11 12 13 14      41 31 21 11
 * 1 2 3 4        2 2 2 2      |     21 22 23 24      42 32 22 12
 * 1 2 3 4        3 3 3 3      |     31 32 33 34      43 33 23 13
 * 1 2 3 4        4 4 4 4      |     41 42 43 44      44 34 24 14
 */

public class RotateMatrix {

    private static int[][] rotateN2SpaceN2(int[][] m) {
        int n = m.length;
        int[][] r = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                r[i][j] = m[n-1-j][i];
            }
        }
        return r;
    }

    private static int[][] rotateN2Space1(int[][] m) {
        int n = m.length;

        for(int i=0; i<n/2; i++) {
            for(int j=0; j<(n+1)/2; j++) {
                int temp = m[i][j];
                m[i][j] = m[n-1-j][i];
                m[n-1-j][i] = m[n-1-i][n-1-j];
                m[n-1-i][n-1-j] = m[j][n-1-i];
                m[j][n-1-i] = temp;
            }
        }
        return m;
    }

    public static void main(String ...args) {
        int[][] m = {{1,2, 3, 4}, {1,2, 3, 4}, {1,2, 3, 4}, {1,2, 3, 4}};
        System.out.println("INPUT:\n");
        for(int[] x : m)
            System.out.println(Arrays.toString(x));
        int[][] r = rotateN2SpaceN2(m);
        System.out.println("\n\nOUTPUT O(N^2) Space O(N^2) :\n");
        for(int[] x : r)
            System.out.println(Arrays.toString(x));
        int[][] t = rotateN2Space1(m);
        System.out.println("\n\nOUTPUT O(N^2) Space O(1) :\n");
        for(int[] x : t)
            System.out.println(Arrays.toString(x));
    }
}

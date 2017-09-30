package arrays;

/**
 * Given an n x n matrix and a number x, find position of x in the matrix if it is present in it. Else print “Not Found”.
 * In the given matrix, every row and column is sorted in increasing order.
 * The designed algorithm should have linear time complexity.
 *
 * Example :
 *          Input : mat[4][4] = { {10, 20, 30, 40},
 *                              {15, 25, 35, 45},
 *                              {27, 29, 37, 48},
 *                              {32, 33, 39, 50}};
 *
 *          x = 29
 *
 * Output : Found at (2, 1)
 */

public class SearchInSortedMatrix {

    public static void findElement(int[][] m, int x) {
        if(m.length == 0) {
            System.out.println("Not Found");
        }

        int n = m.length;
        int i = 0;
        int j = n-1;
        while (i < n && j >= 0) {
            if(m[i][j] == x) {
                System.out.println("Found at (" + i + ", " + j + ")");
                return;
            }

            if(m[i][j] < x) {
                i++;
            } else {
                j--;
            }

        }
        System.out.println("Not Found");
    }

    public static void main(String ...args) {
        int[][] m = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int x = 150;

        findElement(m, x);
    }
}

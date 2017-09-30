package arrays;

/**
 * Given a sorted matrix mat[n][m] and an element ‘x’.
 * Find position of x in the matrix if it is present, else print -1.
 * Matrix is sorted in a way such that all elements in a row are sorted in increasing order and for row ‘i’, where 1 <= i <= n-1, first element of row 'i' is greater than or equal to the last element of row 'i-1'.
 * The approach should have O(log n + log m) time complexity.
 *
 * Examples:
 *          Input : mat[][] =   { {1, 5, 9}
 *                              {14, 20, 21}
 *                              {30, 34, 43}
 *          x = 14
 *
 * Output : Found at (1, 0)
 *
 *          Input : mat[][] =   { {1, 5, 9, 11}
 *                              {14, 20, 21, 26}
 *                              {30, 34, 43, 50}
 *          x = 4
 *
 * Output : -1
 *
 * Approach 1: Convert each row into a 1D array and do a Binary Search
 * Approach 2:
 *
 * 1. Binary Search middle row until 2 elements are left or if x is found during the search
 * 2. Check if x is one of the middle elements of the rows to which the 2 elements belong.
 * 3. If not, find x in 1st half of 1st row or 2nd half of 1st row or 1st half of 2nd row or 2nd half of 2nd row
 */

public class SearchElementInStrictlySortedMatrix {

    public static void binarySearch(int[][] m, int i, int jLow, int jHigh, int x) {

        while (jLow <= jHigh) {
            int jMid = (jLow + jHigh) / 2;

            if(m[i][jMid] == x) {
                System.out.println("Found at (" + i + ", " + jMid + ")");
                return;
            } else if(m[i][jMid] > x) {
                jHigh = jMid - 1;
            } else {
                jLow = jMid + 1;
            }
        }

        System.out.println("-1");
    }

    public static void findElement(int[][] m, int x) {
        if(m.length == 0) {
            System.out.println("-1");
            return;
        }

        int n = m.length;
        int k = m[0].length;
        if(n == 1) {
            binarySearch(m, 0, 0, n - 1, x);
        }


        int iLow =  0;
        int iHigh = n - 1;
        int jMid = k / 2;

        while ((iLow + 1) < iHigh) {

            int iMid = (iLow + iHigh) / 2;

            if(m[iMid][jMid] == x) {
                System.out.println("Found at (" + iMid + ", " + jMid + ")");
                return;
            } else if(m[iMid][jMid] > x) {
                iHigh = iMid;
            } else {
                iLow = iMid;
            }
        }

        if(m[iLow][jMid] == x) {
            System.out.println("Found at (" + iLow + ", " + jMid + ")");
            return;
        } else if(m[iLow+1][jMid] == x) {
            System.out.println("Found at (" + iLow+1 + ", " + jMid + ")");
            return;
        } else if(x <= m[iLow][jMid-1]) {
            binarySearch(m, iLow, 0, jMid-1, x);
        } else if(x >= m[iLow][jMid+1] && x <= m[iLow][k-1]) {
            binarySearch(m, iLow, jMid+1, k-1, x);
        } else if(x <= m[iLow+1][jMid-1]) {
            binarySearch(m, iLow+1, 0, jMid-1, x);
        } else {
            binarySearch(m, iLow+1, jMid+1, k-1, x);
        }
    }

    public static void main(String ...args) {
        int[][] m = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}};
        int x = 14;

        findElement(m, x);
    }
}

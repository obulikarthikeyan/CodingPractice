package leetcode;

import java.util.Scanner;

/**
 * Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value n as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 *
 * Number of entries in every line is equal to line number.
 * For example, the first line has “1”, the second line has “1 1”, the third line has “1 2 1”,.. and so on.
 * Every entry in a line is value of a Binomial Coefficient. The value of ith entry in line number line is C(line, i).
 * The value can be calculated using following formula.
 *
 * C(line, i) = C(line, i-1) * (line - i + 1) / i
 *
 * C(line, i)   = line! / ( (line-i)! * i! )
 *
 * So C(line, i) can be calculated from C(line, i-1) in O(1) time
 *
 */

public class PascalsTriangle {

    //T: O(N^2) S: O(1)
    // This solution might cause integer overflow for large value of n since multiplication operation involved.
    public static void printPascalsTriangle(int n) {
        if (n <= 0) return;
        for (int line = 1; line <= n; line++) {
            int C = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    //T: O(N^2) S: O(N^2)
    public static void printPascalsTriangleN2Space(int n) {
        int[][] a = new int[n][n];

        for (int line = 0;  line < n; line++) {
            for (int i = 0; i <= line; i++) {

                //each line starts and ends with 1
                if(line == i || i == 0) {
                    a[line][i] = 1;
                } else {
                    a[line][i] = a[line-1][i-1] + a[line-1][i];
                }
                System.out.print(a[line][i] + " ");
            }
            System.out.println();
        }
    }

    public static void printPascalsTriangleNSpace(int n) {
        int[] prev = new int[n];
        int[] current = new int[n];

        for(int line = 0; line < n; line++) {
            for (int i=0; i <= line; i++) {
                if (line == i || i == 0) {
                    current[i] = 1;
                } else {
                    current[i] = prev[i-1] + prev[i];
                }
                System.out.print(current[i] + " ");
            }
            int[] temp = prev;
            prev = current;
            current = temp;
            System.out.println();
        }
    }

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        printPascalsTriangle(n);
        System.out.println("\n");
        printPascalsTriangleN2Space(n);
        printPascalsTriangleNSpace(n);
    }
}

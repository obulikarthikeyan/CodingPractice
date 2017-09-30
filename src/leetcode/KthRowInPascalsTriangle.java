package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 *
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class KthRowInPascalsTriangle {

    //T: O(N^2) S: O(N^2)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex == 0) {
            row.add(1);
            return row;
        }
        int[] prev = new int[rowIndex + 1];
        //row.add(1);
        for(int line = 1; line <= rowIndex; line++) {
            row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i < line; i++) {
                row.add(i, prev[i-1] + prev[i]);
            }
            row.add(line, 1);

            for (int i = 0; i < row.size(); i++) {
                prev[i] = row.get(i);
            }

        }

        return row;
    }

    public static List<Integer> getRowSpaceN(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if(rowIndex < 0) {
            return row;
        }
        row.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = row.size() - 2; j >= 0; j--) {
                row.set(j + 1, row.get(j) + row.get(j + 1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int k = scanner.nextInt();
        List<Integer> result = getRow(k);
        System.out.println("\nOutput: " + result.toString());
        result = getRowSpaceN(k);
        System.out.println("\nOutput: " + result.toString());
    }
}

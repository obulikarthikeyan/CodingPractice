package leetcode;

import java.util.Scanner;

/**
 * Given String s = "PAYPALISHIRING" and numRows = 3
 * return the string in zigzag order "PAHNAPLSIIGYIR"
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */

public class ZigZagString {

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String");
        String s = scanner.nextLine();

        System.out.println("Enter numRows");
        int numRows = scanner.nextInt();

        String zigzagString = convert(s, numRows);
        System.out.println("Zigzag string = " + zigzagString);
    }

    private static String convert(String s, int numRows) {
        if(numRows <= 0) {
            return "";
        }

        if(numRows == 1 || s == null || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        StringBuilder result = new StringBuilder();
        boolean down = true;
        int row = 0;

        for(int i=0; i<s.length(); i++) {
            if(row == 0) {
                down = true;
            }

            if(row == numRows - 1) {
                down = false;
            }

            stringBuilders[row].append(s.charAt(i));

            if(down) {
                row++;
            } else {
                row--;
            }
        }

        for (StringBuilder stringBuilder : stringBuilders) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
    }

}

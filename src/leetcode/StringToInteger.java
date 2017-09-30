package leetcode;

import java.util.Scanner;

/**
 * Convert given string to integer
 *
 * Ignoring the white space character in front, if the string contains a non white space,
 * numeric sequence (with the exceptions of + or - symbols), convert them to int
 * and ignore any non-numeric characters that may follow
 *
 * if non-whitespace sequence is not numeric or string has only whitespaces, return 0;
 *
 * if the converted number cannot fit within the integer space, return Integer.MAX_VALUE or Integer.MIN_VALUE
 */

public class StringToInteger {

    private static int convertAtoI(String s) {
        boolean precededByNumeric = false;
        boolean negative = false;
        boolean plusOrMinus = false;
        int r = 0;

        if(s == null || s.length() == 0) {
            return 0;
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);


            if(c == ' ' && !precededByNumeric ) {
            }
            else if(!plusOrMinus && (c == 45 || c == 43)) {
                plusOrMinus = precededByNumeric = true;
                negative = c == 45;
            }
            else if(c >= 48 && c <= 57) {
                long k = r*10L + (c%48);
                if(k > Integer.MAX_VALUE ) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else {
                    r = (int)k;
                }
                precededByNumeric = true;
            } else  {
                break;
            }
        }

        if(negative) {
            r = -r;
        }
        return r;
    }


    public static void main(String ...args) {
        System.out.println("Enter a string");
        String s = new Scanner(System.in).nextLine();
        int n = convertAtoI(s);
        System.out.println("Integer = " + n);
    }
}

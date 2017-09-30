package leetcode;

import java.util.Scanner;

/**
 * Given a 32 bit signed integer, reverse the integer
 * if reverse(i) doesn't fit within the integer space, result = 0
 *
 * i = -4321, result = -1234
 * i = 10000, result = 1
 * i = 1000000003, result = 0
 */

public class ReverseInteger {

    private static int reverse(int x) {
        if(x == 0) {
            return x;
        }

        int r = 0;
        while (x != 0) {
            int k = r*10 + x%10;
            if((k - (x%10))/10 != r) return 0;
            else r = k;
            x /= 10;
        }

        return r;
    }

    public static void main(String ...args) {
        System.out.println("Enter a 32 bit signed integer");
        int x = new Scanner(System.in).nextInt();
        int result = reverse(x);
        System.out.println("Reversed int of " + x + " is " + result);
    }
}

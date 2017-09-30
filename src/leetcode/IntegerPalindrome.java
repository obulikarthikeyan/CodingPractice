package leetcode;

import java.util.Scanner;

/**
 * Check if given integer is palindrome
 * x = 1221, true
 * x = 0, true
 * x = -1, true
 * x = 2212, false
 * x = 21212, true
 * x = 22, true
 */
public class IntegerPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int divisor = 1;

        while (x / divisor >= 10) {
            divisor *= 10;
        }

        while (x != 0) {
            int y = x / divisor;
            int z = x % 10;
            if(y != z) {
                return false;
            }
            x = (x % divisor) / 10;
            divisor /= 100;
        }
        return true;
    }


    public static void main(String ...args) {
        System.out.println("Enter an integer");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Is " + x + " a palindrome? " + new IntegerPalindrome().isPalindrome(x));
    }

}

package leetcode;

import java.util.Scanner;

/**
 * Given String s find the longest palindromic substring of s
 *
 * Example: s = babad, longestPalindromicSubstring = bab or aba
 *
 * Hint: log(n^2) using Dynamic Programming
 */
public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        String longest = null;
        boolean[][] matrix = new boolean[n][n];
        int maxLen = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                int k = j + i;
                if(s.charAt(j) == s.charAt(k) && (i <= 1 || matrix[j+1][k-1])) {
                    matrix[j][k] = true;

                    if(i + 1 > maxLen) {
                        maxLen = i + 1;
                        longest = s.substring(j, k + 1);
                    }
                }
            }
        }
        return longest;
    }

    //T: O(N^2) and S: O(N^2)
    public static String longestPalindromicSubstringAlternative(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        boolean[][] table = new boolean[n][n];

        int start = 0;
        int maxLength = 1;
        for(int i=0; i<n; i++) {
            table[i][i] = true;
        }

        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k<=n; k++) {
            for (int i = 0; i < n-k+1; i++) {
                int j = i + k - 1;
                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;

                    if(k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    //T: O(N^2) and S: O(1)
    public static String longestPalindromicSubstringSpaceO1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = 0;
        int n = s.length();
        int maxLength = 1;

        int low, high;

        for(int i=1; i<n; i++) {

            //Find the longest even length palindrome by fixing i and i-1 as center
            low = i-1;
            high = i;

            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                int diff = low - high + 1;
                if(diff > maxLength) {
                    start = low;
                    maxLength = diff;
                }
                low--;
                high++;
            }

            //Find the longest odd length palindrome by fixing i as center
            low = i - 1;
            high = i + 1;

            while (low >= 0 && high <n && s.charAt(low) == s.charAt(high)) {
                int diff = high - low + 1;
                if(diff > maxLength) {
                    start = low;
                    maxLength = diff;
                }
                low--;
                high++;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String ...args) {
        System.out.println("Enter a String");
        String s = new Scanner(System.in).nextLine();

        System.out.println(String.format("Longest Palindromic Substring of %s is %s", s, longestPalindromicSubstring(s)));
        System.out.println(String.format("Longest Palindromic Substring of %s is %s", s, longestPalindromicSubstringAlternative(s)));
        System.out.println(String.format("Longest Palindromic Substring of %s is %s", s, longestPalindromicSubstringSpaceO1(s)));
    }
}

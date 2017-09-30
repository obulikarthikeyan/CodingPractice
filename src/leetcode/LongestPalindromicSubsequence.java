package leetcode;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 *
 * For example, if the given sequence is “BBABCBCAB”
 * Output should be 7 as “BABCBAB” is the longest palindromic sub sequence in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 *
 */
public class LongestPalindromicSubsequence {

    public static int longestPalindromicSubsequenceN2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        if(n == 1) {
            return 1;
        }

        int[][] m = new int[n][n];

        for(int i=0; i<n; i++) {
            m[i][i] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for(int i=0; i < n-k+1; i++) {
                int j = i + k - 1;

                if(s.charAt(i) == s.charAt(j) && k == 2) {
                    m[i][j] = 2;
                } else if(s.charAt(i) == s.charAt(j)) {
                    m[i][j] = 2 + m[i+1][j-1];
                } else {
                   m[i][j] = Math.max(m[i+1][j], m[i][j-1]);
                }
            }
        }
        return m[0][n-1];
    }

    public static void main(String ...args) {
        String s = "BBABCBCAB";
        System.out.println("Length of Longest Palindromic substring: " + longestPalindromicSubsequenceN2(s));
    }
}

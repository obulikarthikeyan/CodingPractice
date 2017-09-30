package leetcode;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 *
 * Examples:
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */

public class LongestCommonSubSequence {

    public static int longestCommonSubsequenceN2(String x, String y) {
        if(x == null || y == null || x.isEmpty() || y.isEmpty()) {
            return 0;
        }

        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();

        int m = x.length();
        int n = y.length();

        int[][] lcs = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if(i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if(X[i-1] == Y[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[m][n];
    }

    public static void main(String ...args) {
        String x = "ABCGDH";
        String y = "AEDFHR";

        System.out.println("Length of longest common subseqeunce: " + longestCommonSubsequenceN2(x, y));
    }
}

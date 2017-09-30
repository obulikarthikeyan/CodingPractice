package leetcode;

import java.util.Arrays;

/**
 * Given a string that may contain duplicates, write a function to print all permutations of given string such that no permutation is repeated in output.
 *
 * Examples:
 *
 * Input:  str[] = "AB"
 * Output: AB BA
 *
 * Input:  str[] = "AA"
 * Output: AA
 *
 * Input:  str[] = "ABC"
 * Output: ABC ACB BAC BCA CBA CAB
 *
 * Input:  str[] = "ABA"
 * Output: ABA AAB BAA
 *
 * Input:  str[] = "ABCA"
 * Output: AABC AACB ABAC ABCA ACBA ACAB BAAC BACA
 * BCAA CABA CAAB CBAA
 */

public class StringPermutationWithDuplicates {

    public static int ceilIndex(char[] a, char first, int l, int r) {

        int ceilIndex = l;

        for (int i=l+1; i<=r; i++) {
            if(a[i] > first && a[i] < a[ceilIndex]) {
                ceilIndex = i;
            }
        }
        return ceilIndex;
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //T: O(N^2 * N!)
    public static void printDistinctPermutations(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }

        char[] a = str.toCharArray();

        int n = a.length;

        Arrays.sort(a);
        while (true) {
            System.out.println(new String(a));

            char first = '\0';
            int i = n-2;
            for(; i >= 0; i--) {
                if(a[i] < a[i+1]) {
                    first = a[i];
                    break;
                }
            }

            if(i == -1) {
                break;
            }

            int ceilIndex = ceilIndex(a, first, i+1, n-1);
            swap(a, i, ceilIndex);
            Arrays.sort(a, i+1, n);
        }
    }

    public static void main(String ...args) {
        String s = "ACBC";
        printDistinctPermutations(s);
    }

}

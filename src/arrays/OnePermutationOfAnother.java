package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class OnePermutationOfAnother {

    public static void main(String ...args) {
        System.out.println("Enter the 2 strings");
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

        System.out.println("Approach 1 = sorting");
        if(isPermutation_usingSorting(string1, string2)) {
            System.out.println(String.format("Yes, %s is a permutation of %s", string1, string2));
        } else {
            System.out.println(String.format("No, %s is not a permutation of %s", string1, string2));
        }

        System.out.println("Approach 2 = letter counting");
        if(isPermutation_usingCounting(string1, string2)) {
            System.out.println(String.format("Yes, %s is a permutation of %s", string1, string2));
        } else {
            System.out.println(String.format("No, %s is not a permutation of %s", string1, string2));
        }
    }

    private static boolean isPermutation_usingCounting(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }

        int[] letters = new int[256];

        for(char c : string1.toCharArray()) {
            letters[c]++;
        }

        for (char c : string2.toCharArray()) {
            if(--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPermutation_usingSorting(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return String.valueOf(sArray);
    }
}

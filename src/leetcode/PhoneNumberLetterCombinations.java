package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

public class PhoneNumberLetterCombinations {

    public static void letterCombinations(String prefix, String digitStr, String[] letters, List<String> result, int offset) {
        if(offset >= digitStr.length()) {
            result.add(prefix);
            return;
        }

        String letterStr = letters[digitStr.charAt(offset) - '0'];
        for(int i=0; i<letterStr.length(); i++) {
            letterCombinations(prefix + letterStr.charAt(i), digitStr, letters, result, offset + 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
       List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return result;
        }

        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        letterCombinations("", digits, letters, result, 0);
        return result;
    }

    public static void main(String ...args) {
        System.out.println("Enter digit string");
        String digits = new Scanner(System.in).nextLine();
        System.out.println("Letter combinations = " + letterCombinations(digits).stream().collect(Collectors.joining(", ")));
    }
}

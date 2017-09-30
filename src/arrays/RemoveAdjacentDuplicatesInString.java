package arrays;

import java.util.Stack;

/**
 * Given a string, recursively remove adjacent duplicate characters from string.
 * The output string should not have any adjacent duplicates.
 *
 * Input:  azxxzy
 * Output: ay
 *
 * First "azxxzy" is reduced to "azzy". The string "azzy" contains duplicates,
 * so it is further reduced to "ay".
 *
 * Input: caaabbbaacdddd
 * Output: Empty String
 *
 * Input: acaaabbbacdddd
 * Output: acac
 */
public class RemoveAdjacentDuplicatesInString {

    //T: O(N) S: O(1)
    public static String removeAdjacentDuplicatesRecursively(String s, char removed) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        if(s.charAt(0) == s.charAt(1)) {
            while (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
                s = s.substring(1);
            }
            return removeAdjacentDuplicatesRecursively(s.substring(1), s.charAt(0));
        }

        String rem = removeAdjacentDuplicatesRecursively(s.substring(1), removed);
        if(rem.length() > 0 && s.charAt(0) == rem.charAt(0)) {
            removed = s.charAt(0);
            return rem.substring(1);
        }
        if(s.charAt(0) == removed) {
            return rem;
        }
        return s.charAt(0) + rem;
    }

    //Using Stack T: O(N) S: O(N)
    public static String removeAdjacentDuplicatesIteratively(String s){
        if (s == null || s.length() <= 1) {
            return s;
        }

        //azxxzy
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        int i = 1;
        char c = '\0';
        while (i < s.length()) {
            if(s.charAt(i) == stack.peek()) {
                c = stack.pop();
            } else if(c != s.charAt(i)) {
                stack.push(s.charAt(i));
            }
            i++;
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    public static void main(String ...args) {
        String s = "azxxzy";
        System.out.println("Input: " + s);
        System.out.println("Output: " + removeAdjacentDuplicatesRecursively(s, '\0'));
        System.out.println("Output: " + removeAdjacentDuplicatesIteratively(s));

        s = "acbbcddck";
        System.out.println("\nInput: " + s);
        System.out.println("Output: " + removeAdjacentDuplicatesRecursively(s, '\0'));
        System.out.println("Output: " + removeAdjacentDuplicatesIteratively(s));

        s = "acaaabbbacdddd";
        System.out.println("\nInput: " + s);
        System.out.println("Output: " + removeAdjacentDuplicatesRecursively(s, '\0'));
        System.out.println("Output: " + removeAdjacentDuplicatesIteratively(s));

    }
}

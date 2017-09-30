package arrays;

/**
 * Given a String S, find the non repeating character
 *
 * Example:
 *
 * Input: "abcddbacrgdgab"
 *
 * Output: r
 */

public class FindNonRepeatingCharInString {

    public static Character getNonRepeatingCharacter(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }

        int[] index = new int[256];

        for (int i = 0; i<s.length(); i++) {
            index[s.charAt(i)]++;
        }

        for (int i=0; i<256; i++) {
            if(index[i] == 1) {
                return (char)i;
            }
        }
        return null;
    }

    public static void main(String ...args) {
        String s = "abcddbacrgdgab";
        System.out.println("Input: " + s);
        System.out.println("\nOutput: " + getNonRepeatingCharacter(s));
    }
}

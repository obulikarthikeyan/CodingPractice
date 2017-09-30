package leetcode;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example
 * s = "anagram", t = "nagaram", return true
 * s = "rat", t = "car", return false
 *
 * Note
 * You may assume the string contains only lowercase alphabets.
 */

public class ValidAnagram {

    //T: O(N) S: O(N)
    public static boolean isValdAnagramNaive(String s, String t) {
        if(s == null || t == null) {
            return s == t;
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        s = new String(sArray);
        t = new String(tArray);

        return s.equals(t);
    }

    //T: O(N) S: O(26)
    public static boolean isValidAnagramConstantSpace(String s, String t) {
        if(s == null || t == null) {
            return s == t;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int[] temp = new int[26];

        for (int i=0; i<s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++) {
            temp[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<temp.length; i++) {
            if(temp[i] != 0) {
                return false;
            }
        }

        return true;
    }

    //T: O(N) S: O(26)
    public static boolean isValidAnagramConstantSpaceOptimized(String s, String t) {
        if(s == null || t == null) {
            return s == t;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int[] temp = new int[26];

        for (int i=0; i<s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++) {
            if(--temp[s.charAt(i) - 'a'] < 0) {
                return false;
            }
        }


        return true;
    }

    public static void main(String ...args) {
        String s = "anagram";
        String t = "nagaram";

        String x = "act";
        String y = "rat";

        System.out.println("Naive approach:\n");
        System.out.println("\'" + s + "\' and \'" + t + "\' valid anagrams? " + isValdAnagramNaive(s, t));
        System.out.println("\n\'" + x + "\' and \'" + y + "\' valid anagrams? " + isValdAnagramNaive(x, y));

        System.out.println("\nConstant Space:\n");
        System.out.println("\n\'" + s + "\' and \'" + t + "\' valid anagrams? " + isValidAnagramConstantSpace(s, t));
        System.out.println("\n\'" + x + "\' and \'" + y + "\' valid anagrams? " + isValidAnagramConstantSpace(x, y));

        System.out.println("\nConstant Space Optimized:\n");
        System.out.println("\n\'" + s + "\' and \'" + t + "\' valid anagrams? " + isValidAnagramConstantSpace(s, t));
        System.out.println("\n\'" + x + "\' and \'" + y + "\' valid anagrams? " + isValidAnagramConstantSpace(x, y));
    }
}

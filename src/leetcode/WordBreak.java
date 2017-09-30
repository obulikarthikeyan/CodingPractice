package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {

    //T: O(N^2)
    public static boolean wordBreakN2(String s, List<String> dict) {
        if (s.length() == 0) {
            return true;
        }

        return wordBreakN2Helper(s, dict, 0);
    }

    private static boolean wordBreakN2Helper(String s, List<String> dict, int start) {
        if(start == s.length()) {
            return true;
        }

        for (String a : dict) {
            int len = a.length();
            int end = start + len;

            if(end > s.length()) {
                continue;
            }

            if(s.substring(start, end).equals(a)) {
                if(wordBreakN2Helper(s, dict, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    //T: O(N = length of s * M = size of dict) Uses Dynamic Programming to reference partial results
    //S: O(N)
    //If size of dictionary is too large, Time complexity is high
    public static boolean wordBreakUsingDP(String s, List<String> dict) {
        boolean[] temp = new boolean[s.length() + 1];
        temp[0] = true;

        for(int i=0; i < s.length(); i++) {

            if(!temp[i]) {
                continue;
            }

            for (String a : dict) {
                int len = a.length();
                int end = i + len;

                if(end > s.length()) {
                    continue;
                }

                if(temp[end]) {
                    continue;
                }

                if(s.substring(i, end).equals(a)) {
                    return true;
                }
            }
        }
        return false;
    }

    //T: O(N^2) but better than worst case of DP solution
    public static boolean wordBreakAdvancedDP(String s, List<String> dict) {
        if(s.length() == 0) {
            return true;
        }

        int[] temp = new int[s.length() + 1];
        Arrays.fill(temp, -1);
        temp[0] = 0;

        for (int i=0; i<s.length(); i++) {
            if(temp[i] != -1) {
                for(int j=i+1; j<=s.length(); j++) {
                    if(dict.contains(s.substring(i, j))) {
                        temp[j] = i;
                    }
                }
            }
        }
        return temp[s.length()] != -1;
    }

    public static boolean wordBreakEasy(String s, List<String> dict) {
        if(s.length() == 0) {
            return true;
        }

        for (int i=1; i<=s.length(); i++) {
            String first = s.substring(0, i);
            String rest = s.substring(i);
            if(dict.contains(first) && wordBreakEasy(rest, dict)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String ...args) {
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println("WorkBreakEasy ? " + wordBreakEasy(s, dict));
        System.out.println("WorkBreakN2 ? " + wordBreakN2(s, dict));
        System.out.println("WorkBreakUsingDP ? " + wordBreakUsingDP(s, dict));
        System.out.println("WorkBreakAdvancedDP ? " + wordBreakAdvancedDP(s, dict));
    }
}

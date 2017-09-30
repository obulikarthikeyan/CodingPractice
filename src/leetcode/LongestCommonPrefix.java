package leetcode;

/**
 * Given  an array of Strings, return the longest common prefix
 *
 * ["string", "str", "set"] => "s"
 * ["string", "hello", "str"] => ""
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        int count = 0;
        for(int j=0; j<strs[0].length(); j++) {
            for(int i=0; i<strs.length-1; i++) {
                if(j >= strs[i+1].length() || strs[i].charAt(j) != strs[i+1].charAt(j)) {
                    return strs[0].substring(0, count);
                }
            }
            count++;
        }
        return strs[0];
    }

    public static void main(String ...args) {
        String[] strings = {"string", "stringer", "stringest"};
        System.out.println("Longest common prefix = " + new LongestCommonPrefix().longestCommonPrefix(strings));
    }
}

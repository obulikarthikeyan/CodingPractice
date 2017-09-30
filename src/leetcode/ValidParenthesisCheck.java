package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParenthesisCheck {

    public static boolean isValid(String s) {
        if(s == null || s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            } else if(map.containsValue(c)) {
                if(!stack.empty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String ...args) {
        System.out.println("Enter the parenthesis string");
        String s = new Scanner(System.in).nextLine();
        System.out.println(s + " is a valid parenthesis string? " + isValid(s));
    }
}

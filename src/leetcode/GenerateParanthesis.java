package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class GenerateParanthesis {

    public static void dfs(List<String> result, String s, int open, int close) {
        if(open > close) {
            return;
        }

        if(open == 0 && close == 0) {
            result.add(s);
            return;
        }

        if(open > 0) {
            dfs(result, s + '(', open - 1, close);
        }

        if(close > open) {
            dfs(result, s + ')', open, close - 1);
        }
    }

    public static void main(String ...args) {
        System.out.println("Enter n");
        int n = new Scanner(System.in).nextInt();
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        System.out.println("\nParenthesis combinations\n" + result.stream().collect(Collectors.joining(", ")));
    }
}

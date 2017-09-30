package leetcode;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *      "3+2*2" = 7
 *      " 3/2 " = 1
 *      " 3+5 / 2 " = 5
 *      "8/ 4+4" = 6
 */
public class EvaluateExpressionString {

    //T: O(N) S: O(1)
    public static void calculateNSpace1(String s) {

        if (s == null) return;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        System.out.println(res);
    }

    //Using two stacks, 1 for operator and another for values
    //T: O(N) S: O(N^2)
    public static void calculateNSpaceN2(String s) {
        if(s == null || s.length() == 0) {
            return;
        }

        Stack<Integer> valuesStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }

            if(Character.isDigit(c)) {
                valuesStack.push(c - '0');
            } else if(operatorStack.isEmpty() ) {
                operatorStack.push(c);
            } else if(operatorStack.peek() != '/' && operatorStack.peek() != '*') {
                operatorStack.push(c);
            } else {
                int b = valuesStack.pop();
                int a = valuesStack.pop();

                char t = operatorStack.pop();
                switch (t) {
                case '+':
                    valuesStack.push(a + b);
                    break;
                case '-':
                    valuesStack.push(a - b);
                    break;
                case '*':
                    valuesStack.push(a * b);
                    break;
                case '/':
                    valuesStack.push(a / b);
                    break;
                }
            }
        }

//        while (!operatorStack.isEmpty()) {
//            int a = valuesStack.pop();
//            int b = valuesStack.pop();
//
//            char t = operatorStack.pop();
//
//            switch (t) {
//                case '+':
//                    valuesStack.push(a + b);
//                    break;
//                case '-':
//                    valuesStack.push(a - b);
//                    break;
//                case '*':
//                    valuesStack.push(a * b);
//                    break;
//                case '/':
//                    valuesStack.push(a / b);
//                    break;
//            }
//        }

        System.out.println(valuesStack.pop() + valuesStack.pop());
    }

    public static void main(String ...args) {
        String s = "16* 4+2/4";
        calculateNSpace1(s);
        //calculateNSpaceN2(s);
    }

}

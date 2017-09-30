package arrays;

import java.util.Scanner;

public class StringReversal {

    public static void main(String ...args) {
        System.out.println("Enter the String to be reversed");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("reverseUsingRecursion(str) = " + reverseUsingRecursion(str, str.length() - 1));
        System.out.println("reverse(str) = " + reverse(str));
    }

    private static String reverseUsingRecursion(String str, int index) {
        if(index < 0) {
            return "";
        }

        return str.charAt(index) + reverseUsingRecursion(str, index - 1);
    }

    private static String reverse(String str) {
        int n = str.length();
        char[] strArray = str.toCharArray();
        for(int i=0; i<str.length()/2; i++) {
            char t = strArray[i];
            strArray[i] = strArray[--n];
            strArray[n] = t;
        }
        return String.valueOf(strArray);
    }
}

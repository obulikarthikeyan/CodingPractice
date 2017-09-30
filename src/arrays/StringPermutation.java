package arrays;

import java.util.Scanner;

public class StringPermutation {

    public static void main(String ...args) {
        System.out.println("Enter the string that needs to be permutated");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str != null && !str.equals("")) {
            printPermutation(str);
        }
        System.out.println("\n\n");
        permuteBacktracking(str);

        String s = "string";

        int[] c = new int[266];

        for(int i=0; i<s.length(); i++) {
            ++c[s.charAt(i)];
        }

        for(int i=1; i<256; i++) {
            c[i] += c[i-1];
            System.out.println("char = " + (char)i + " " + c[i]);
        }
    }

    private static void printPermutation(String str) {
        permute("", str);
    }

    private static void permute(String perm, String str) {
        if(str.isEmpty()) {
            System.out.println(perm);
        }

        for(int i=0; i<str.length(); i++) {
            permute(perm + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
        }
    }

    public static void permuteBacktracking(String str) {
        permuteUtil(str, 0, str.length() - 1);
    }

    private static void permuteUtil(String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permuteUtil(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

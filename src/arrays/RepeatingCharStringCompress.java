package arrays;

import java.util.Scanner;

public class RepeatingCharStringCompress {


    public static void main(String ...args) {
        System.out.println("Enter the string to be compressed");
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        System.out.println("compressed string = " + compressBad(string1));
    }

    private static String compressBad(String str) {
        String compressedString = "";
        int count = 1;
        char last = str.charAt(0);

        for(int i=1; i < str.length(); i++) {
            if(str.charAt(i) == last) {
                count++;
            } else {
                compressedString = compressedString + last + count;
                last = str.charAt(i);
                count = 1;
            }
        }
        return  compressedString + last + count;
    }
}

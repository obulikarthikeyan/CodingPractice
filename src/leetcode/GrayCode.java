package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 1 << n ==> 2^n ( here ^ represents power of, however in case of java ^ is a XOR operator)
 * n >> 1 ==> n / 2
 */

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> result;

        if(n == 0) {
            result = new ArrayList<>();
            result.add(0);
            return result;
        }

        result = grayCode(n-1);

        int numToAdd = 1 << (n-1);

        for(int i = result.size() - 1; i >= 0; i--) {
            result.add(numToAdd + result.get(i));
        }

        return result;
    }

    //n * floor(n/2)
    public  static void greyCodeA(int n)
    {
        //int totalN = (int) Math.pow(2,n);
        for (int i = 0; i < 1 << n; i++)
        {
            //int greyCode = i ^ (i / 2);
            int greyCode = i ^ (i >> 1);
            System.out.println(greyCode);

           intToBinary(greyCode, n); // Converts the num to binary pattern

        }
    }

    public static void intToBinary(int n, int numBits) {
        String binaryString = (n == 0) ? "0" : "";
        int rem;
        while (n != 0) {
            rem = n % 2;
            binaryString = rem + binaryString;
            n = n / 2;
        }
        int diff = numBits - binaryString.length();
        for(int i = 0; i < diff; i++) {
            binaryString = "0" + binaryString;
        }
        System.out.println(binaryString);
    }

    public static void main(String ...args) {
        int n = 4;
        List<Integer> result = grayCode(n);
        System.out.println("NumToAdd Approach\n");
        System.out.println(result.toString());
        System.out.println("\nXOR approach\n");
        greyCodeA(n);
    }
}

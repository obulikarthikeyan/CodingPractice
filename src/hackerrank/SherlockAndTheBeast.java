package hackerrank;

import java.util.Scanner;

/**
 * A Decent Number has the following properties:
 *  Its digits can only be 3's and/or 5's.
 *  The number of 3's it contains is divisible by 5.
 *  The number of 5's it contains is divisible by 3.
 *  If there are more than one such number, we pick the largest one.
 *
 * Sample Input
 * 1
 * 3
 * 5
 * 11
 *
 * Sample Output
 *
 * -1
 * 555
 * 33333
 * 55555533333
 */

public class SherlockAndTheBeast {

    private static String solve(int N) {
        for (int i = 0; i * 5 <= N; i++) {
            if ((N - i * 5) % 3 == 0) {
                StringBuilder ret = new StringBuilder();
                int a = (N - i * 5) / 3;
                for (int j = 0; j < a; j++) {
                    ret.append("555");
                }
                for (int j = 0; j < i; j++)
                    ret.append("33333");
                return ret.toString();
            }
        }
        return "-1";
    }

    public static void printDecentNumber(long[] testcases) {
        for (int k = 0; k < testcases.length; k++) {
            long n = testcases[k];
            if (n <= 0) {
                System.out.println("-1");
            }

            String s = "";
//            if (n % 3 == 0) {
//                while (n != 0) {
//                    n -= 3;
//                    s += "555";
//                }
//            } else if (n % 5 == 0) {
//                while (n != 0) {
//                    n -= 5;
//                    s += "33333";
//                    System.out.println(s);
//                }
//            } else {
                while (n > 0) {

                    n -= 3;
                    s += "555";
                    if (n % 5 == 0) {
                        while (n != 0) {
                            n -= 5;
                            s += "33333";
                        }
                        break;
                    }
                }
                s = (n == 0) ? s : "-1";
           // }
            System.out.println(s + " === " + s.length());
        }
    }

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if(t > 0) {
            long[] testcases = new long[t];
            for (int i=0; i<t; i++) {
                testcases[i] = scanner.nextLong();
                System.out.println(solve((int)testcases[i]));
            }
            //printDecentNumber(testcases);
        }
    }

}

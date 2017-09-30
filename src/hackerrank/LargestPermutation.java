package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given an array of N integers which is a permutation of the first K natural numbers. You can swap any two elements of the array.
 * You can make at most K swaps. What is the largest permutation, in numerical order, you can make?

 * Input Format
 * The first line of the input contains two integers, N and K, the size of the input array and the maximum swaps you can make, respectively.
 * The second line of the input contains a permutation of the first N natural numbers.
 *
 * Output Format
 * Print the lexicographically largest permutation you can make with at most  swaps.
 *
 *
 * Sample Input#00
 *
 * 5 1
 * 4 2 3 5 1
 * Sample Output#00
 *
 * 5 2 3 4 1
 * Explanation#00
 * You can swap any two numbers in  and see the largest permutation is
 *
 * Sample Input#01
 *
 * 3 1
 * 2 1 3
 * Sample Output#01
 *
 * 3 1 2
 * Explanation#01
 * With 1 swap we can get ,  and  out of these  is the largest permutation.
 *
 * Sample Input#02
 * 2 1
 * 2 1
 * Sample Output#02
 *
 * 2 1
 * Explanation#02
 * We can see that  is already the largest permutation. So we don't need any swaps.
 *
 * 3 4 2 5 1
 *
 * 1 -> 5 4 2 3 1
 * 2 ->
 *
 */
public class LargestPermutation {

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if(n > 0) {
            int[] a = new int[n];
            int[] pos = new int[n+1];
            for (int i=0; i<n; i++) {
                a[i] = scanner.nextInt();
                pos[a[i]] = i;
            }

            printLargestPermutation(a, pos, n, k);
            for (int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void printLargestPermutation(int[] a, int[] pos, int n, int k) {
        if (a == null || a.length == 0) {
            return;
        }

        if (k <= 0) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (int i=0; i<n && k > 0; i++) {

            if (a[i] == n-i) {
                continue;
            }

            int t = pos[n-i];

            pos[a[i]] = pos[n-i];
            pos[n-i] = i;

            int temp = a[t];
            a[t] = a[i];
            a[i] = temp;

            k--;
        }
    }
}

package hackerrank;

import java.util.Arrays;

/**
 * Created by osampath on 8/15/17.
 */
public class ArrayMinimumUnfairness {

    public static int minUnfairness(int[] a, int k) {
        Arrays.sort(a);

        return a[k-1] - a[0];
    }


    public static void main(String ...args) {
        //int[] a = {10, 100, 300, 200, 1000, 20, 30};
        //int[] a = {1, 2, 2, 2, 2, 20, 30, 40, 100, 200};
        int[] a = {1, 2, 8, 20, 20, 20, 20, 40, 100, 200};

        int k = 5;
        System.out.println(minUnfairness(a, k));
    }
}

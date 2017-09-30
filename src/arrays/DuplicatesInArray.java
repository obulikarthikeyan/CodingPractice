package arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

/**
 * Given an array of n integers in the range 0 to n, print duplicates in the array
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */

public class DuplicatesInArray {

    static void duplicatesN2Time(int[] a) {
        if(a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i] == a[j]) {
                    System.out.println(a[i]);
                }
            }
        }
    }

    static void duplicatesNTimeNSpace(int[] a) {
        if(a.length <= 1) {
            return;
        }
        boolean[] duplicates = new boolean[a.length];

        for (int i = 0; i < a.length; i++ ) {
            if(duplicates[a[i]]) {
                System.out.println(a[i]);
            } else {
                duplicates[a[i]] = true;
            }
        }
    }

    /**
     * May Print duplicates more than once. For [1, 2, 1, 2, 1, 3] prints 2, 1, 1
     * @param a
     */
    static void duplicatesNTime1Space(int[] a) {
        if (a.length <= 1) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if(a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.println(a[i]);
            }
        }
    }

    static void duplicatesNTime1SpacePrintOnce(int[] a) {
        if(a.length <= 1) {
            return;
        }

        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = a[i] % n;
            a[index] += n;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] / n > 1) {
                System.out.println(i);
            }
        }
    }

    static void duplicatesNTimeNSpaceUsingHashSet(int[] a) {
        if(a.length <= 1) {
            return;
        }
        HashSet<Integer> set = new HashSet<>(a.length);
        for (int i : a) {
            if(!set.add(i)) {
                System.out.println(i);
            }
        }
    }

    static void duplicatesNTimeUsingBitSet(int[] a) {
        if (a.length <= 1) {
            return;
        }

        BitSet bitSet = new BitSet(a.length);
        for (int i : a) {
            if(bitSet.get(i)) {
                System.out.println(i);
            } else {
                bitSet.set(i);
            }
        }
    }


    public static void main(String ...args) {
        int[] a = {1, 2, 4, 2, 0, 1, 0, 1};
        System.out.println("Given Array");
        System.out.println(Arrays.toString(a));
        System.out.println("\nDuplicates using duplicatesN2Time()");
        duplicatesN2Time(a);
        System.out.println("\nDuplicates using duplicatesNTimeNSpace()");
        duplicatesNTimeNSpace(a);
        System.out.println("\nDuplicates using duplicatesNTime1Space()");
        duplicatesNTime1Space(a);
        int[] b = {1, 2, 4, 2, 0, 1, 0, 1};
        System.out.println("\nDuplicates using duplicatesNTime1SpacePrintOnce()");
        duplicatesNTime1SpacePrintOnce(b);
        b = new int[]{1, 2, 4, 2, 0, 1, 0, 1};
        System.out.println("\nDuplicates using hash set");
        duplicatesNTimeNSpaceUsingHashSet(b);
        System.out.println("\nDuplicates using BitSet");
        b = new int[]{1, 2, 10009, 2, 0, 1, 10009, 1};
        duplicatesNTimeUsingBitSet(b);

    }
}

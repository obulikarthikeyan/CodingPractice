package arrays;

/**
 * Find all the subsets of a given set.
 *
 * Input:
 * S = {a, b, c, d}
 *
 * Output:
 * {}, {a} , {b}, {c}, {d}, {a,b}, {a,c},
 * {a,d}, {b,c}, {b,d}, {c,d}, {a,b,c},
 * {a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}
 *
 * The total number of subsets of any given set is equal to 2^ (no. of elements in the set).
 * If we carefully notice it is nothing but binary numbers from 0 to 15
 *
 */
public class PowerSet {

    /**
     * Input: Set[], set_size
     * 1. Get the size of power set
     * powet_set_size = pow(2, set_size)
     * 2  Loop for counter from 0 to pow_set_size
     *   (a) Loop for i = 0 to set_size
     *     (i) If ith bit in counter is set, Print ith element from set for this subset
     *   (b) Print seperator for subsets i.e., newline
     *
     * T: O(N*2^N)
     */
    public static void printPowerSet(char[] set) {
        int len = set.length;
        int powerSetLen = (int) Math.pow(2, len);

        for (int i = 0; i < powerSetLen; i++) {

            System.out.print("{");

            for (int j = 0; j < len; j++) {
                if ((i & (1<<j)) > 0) {
                    System.out.print(set[j]);
                }
            }
            System.out.print("}\n");
        }
    }

    public static void main(String ...args) {
        String s = "abcd";
        printPowerSet(s.toCharArray());
    }

}

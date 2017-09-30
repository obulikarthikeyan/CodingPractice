package hackerrank;

import java.util.Scanner;

/**
 *
 */

public class UtopianTree {

    public static int growth(int numCycle) {
        int growth = 1;
        for(int i=1; i<=numCycle; i++) {
            if(i % 2 == 0) {
                growth++;
            } else {
                growth *= 2;
            }
        }
        return growth;
    }

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        if(T > 0) {
            int[] numCycles = new int[T];
            for (int i = 0; i < T; i++) {
                numCycles[i] = scanner.nextInt();
            }
            for (int numCycle : numCycles) {
                System.out.println(growth(numCycle));
            }
        }
    }
}

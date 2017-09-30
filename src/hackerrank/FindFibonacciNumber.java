package hackerrank;

/**
 * Write a function int fib(int n) that returns Fn.
 * For example, if n = 0, then fib() should return 0. If n = 1, then it should return 1. For n > 1, it should return Fn-1 + Fn-2
 *
 * For n = 9
 * Output:34
 */

public class FindFibonacciNumber {

    //T: O(e^n) S: O(1) or O(n)
    public static int generateFibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }
        return generateFibonacci(n-1) + generateFibonacci(n-2);
    }

    //T: O(N) S: O(N)
    public static int fiboUsingDP(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    //T: O(N) S: O(1)
    public static int fiboDPOptimized(int n) {
        int a = 0;
        int b = 1;
        int c;

        for (int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * T: O(N)
     * F = [1, 1]
     *     [1, 0]
     *
     * Power(F, n-1) = [Fn,   Fn-1]
     *                 [Fn-1, Fn-2]
     * **/
    public static int fiboPowerOfMatrix(int n) {
        if(n == 0) {
            return 0;
        }

        int[][] f = {{1, 1}, {1, 0}};
        //power(f, n-1);
        powerOptimized(f, n-1);
        return f[0][0];
    }

    private static void power(int[][] f, int n) {
        int[][] m = {{1, 1}, {1, 0}};

        for(int i=2; i<=n; i++) {
            multiply(f, m);
        }
    }

    private static void multiply(int[][] f, int[][] m) {
        int x = f[0][0]*m[0][0] + f[0][1]*m[1][0];
        int y = f[0][0]*m[0][1] + f[0][1]*m[1][1];
        int z = f[1][0]*m[0][0] + f[0][0]*m[1][0];
        int w = f[1][0]*m[0][1] + f[1][1]*m[1][1];

        f[0][0] = x;
        f[0][1] = y;
        f[1][0] = z;
        f[1][1] = w;
    }

    private static void powerOptimized(int[][] F, int n) {
        if(n == 0 || n == 1) {
            return;
        }
        int[][] m = {{1, 1}, {1, 0}};

        powerOptimized(F, n/2);
        multiply(F,F);

        if(n%2 != 0) {
            multiply(F, m);
        }
    }

    public static void main(String ...args) {
        int n = 0;
        System.out.println("Output: " + generateFibonacci(n));
        System.out.println("\nOutput using DP " + fiboUsingDP(n));
        System.out.println("\nOutput optimized " + fiboDPOptimized(n));
        System.out.println("\nOutput power of matrix " + fiboPowerOfMatrix(n));
    }
}

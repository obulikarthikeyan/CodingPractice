package hackerrank;

/**
 * Given a Number n, check if n is a fibonacci number
 */
public class IsFibo {

    public static boolean isFibo(int n) {
        if(n == 0) {
            return true;
        }

        if(n > 0) {
            int a = 0;
            int b = 1;
            int c = 0;

            while (c < n) {
                c = a + b;
                a = b;
                b = c;
            }

            if (b == n) {
                return true;
            }
        }

        return false;
    }

    public static void main(String ...args) {
        int n = 35;
        System.out.println(n + " is Fibo? " + isFibo(n));
    }
}

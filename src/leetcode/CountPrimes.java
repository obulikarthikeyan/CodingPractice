package leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes {

    //T: O(N^2) S: O(1)
    public static int countPrimesN2(int n) {
        int count = 0;
        if(n <= 0) {
            return count;
        }

        for (int i=2; i<n; i++) {
            boolean isPrime = true;

            for(int j=2; j<i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                count++;
            }
        }
        return count;
    }

    //T: O(N) S: O(N)
    public static int countPrimes(int n) {
        int count = 0;
        if(n > 3) {
            count++;
        }

        boolean[] nonPrimes = new boolean[n+1];

        for(int i = 3; i <= Math.sqrt(n); i = i+2) {
            for(int j = i; i * j <= n; j = j+2) {
                nonPrimes[i*j] = true;
            }
        }

        for (int i=3; i <= n; i = i + 2) {
            if(!nonPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    //T: O(N log log N) S: O(N)
    //Sieve of Eratosthenes
    public static int countPrimesUsingSieveOfEratosthenes(int n) {
        if(n < 3) {
            return 0;
        }

        int count = 0;
        boolean[] nonPrimes = new boolean[n];

        for(int i=2; i < Math.sqrt(n); i++) {
            if(!nonPrimes[i]) {
                for(int j = i*i; j < n; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }

        for(int i=2; i < n; i++) {
            if(!nonPrimes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String ...args) {
        int n = 4;
        System.out.println("Input: " + n);
        System.out.println("\nOutputN2: " + countPrimesN2(n));
        System.out.println("\nOutput: " + countPrimes(n));
        System.out.println("\nOutput Using Sieve of Eratosthenes: " + countPrimesUsingSieveOfEratosthenes(n));
    }
}

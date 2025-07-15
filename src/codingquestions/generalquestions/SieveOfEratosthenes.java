package codingquestions.generalquestions;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        sieveOfEratosthenes(10);
    }

    // time complexity: O(nsqrt(n))
    // space complexity: O(n)
    public static void printAllPrimNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // time complexity: O(nlog(logn))
    // space complexity: O(n)
    public static void sieveOfEratosthenes(int n) {
        boolean[] isprime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isprime[i] = true;
        for (int i = 2; i * i <= n; i++) {
            if (isprime[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.println(i);
            }
        }
    }

    // time complexity: O(nlog(logn))   space complexity: O(n)  
    // optimized version of Sieve of Eratosthenes
    public static void sieveOfEratosthenesoptimized(int n) {
        boolean[] isprime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isprime[i] = true;
        for (int i = 2; i * i <= n; i++) {
            if (isprime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.println(i);
            }
        }
    }

    // time complexity: O(nlog(logn))   space complexity: O(n)
    // optimized version of Sieve of Eratosthenes with less iterations
    public static void ShortersieveOfEratosthenesoptimized(int n) {
        boolean[] isprime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isprime[i] = true;
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.println(i);
                for (int j = i * i; j <= n; j += i) {
                    isprime[j] = false;
                }
            }
        }
    }

    // time complexity: O(sqrt(n))   space complexity: O(1)
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
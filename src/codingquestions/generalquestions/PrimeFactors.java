package codingquestions.generalquestions;

public class PrimeFactors {

    public static void main(String[] args) {
        printprimenumbersefficient(450);
    }

    // time complexity: O(n log n) Space complexity: O(1)
    public static void printprimenumbers(int n) {

        for (int i = 2; i < n; i++) {
            if (isprime(i)) {
                int x = i;
                while (n % x == 0) {
                    System.out.println(x);
                    x *= i;
                }
            }
        }
    }

    // time complexity: O(sqrt(n)) Space complexity: O(1)
    public static void printprimenumbersefficient(int n) {

        if (n <= 1) return; // if n is less than or equal to 1, then it has no prime factors
        if (n % 2 == 0) {
            System.out.println(2);
            n /= 2;
        }
        if (n % 3 == 0) {
            System.out.println(3);
            n /= 3;
        }
        for (int i = 5; i * i <= n; i += 6) {

            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
            while (n % (i + 2) == 0) {
                System.out.println(i + 2);
                n /= (i + 2);
            }

        }
        if (n > 3) System.out.println(n); // if a is still greater than 1, then it is a prime factor
    }

    public static boolean isprime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

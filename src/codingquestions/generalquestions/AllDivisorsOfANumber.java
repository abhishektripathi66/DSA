package codingquestions.generalquestions;

public class AllDivisorsOfANumber {

    public static void main(String[] args) {
        printAllDivisorsEfficient(25);
    }

    // time complexity: O(n) Space complexity: O(1)
    public static void printAllDivisors(int n) {
        if (isprime(n)) {
            System.out.println(1);

        } else {
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                }
            }
        }
        System.out.println(n);
    }

    // time complexity: O(sqrt(n)) Space complexity: O(1)
    public static void printAllDivisorsEfficient(int n) {
        if (isprime(n)) {
            System.out.println(1);
        } else {
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                }
            }
        }
        System.out.println(n);
    }

    // Function to check if a number is prime
    // time complexity: O(sqrt(n)) Space complexity: O(1)
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

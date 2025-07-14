package codingquestions.generalquestions;

public class PrimeNumber {

    public static void main(String[] args) {

    }

    // time complexity: O(n) Space complexity: O(1)
    // if n is prime, then it has no factors other than 1 and itself
    // if n is not prime, then it has at least one factor other than 1 and itself
    // so we can check if n is divisible by any number from 2 to n/2
    // if it is divisible by any number, then it is not prime
    // if it is not divisible by any number, then it is prime
    public static boolean isPrime(int a) {
        if (a <= 1) return false;
        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    // if (x,y) is a pair, then x*y=n and if x <=y, then x*x<=n, x<=sqrt(n)
    // time complexity: O(sqrt(n)) Space complexity: O(1)
    // so we can check if n is divisible by any number from 2 to sqrt(n)
    public static boolean isPrimeOptimized(int a) {
        if (a <= 1) return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    //time complexity: O(sqrt(n)) Space complexity: O(1)
    // this is an optimized version of the above method
    // we can skip even numbers and check only odd numbers
    // also we can skip multiples of 3
    // so we can check if n is divisible by any number from 2 to sqrt(n)
    // but we can skip even numbers and check only odd numbers
    // and we can also skip multiples of 3
    // so we can check if n is divisible by any number from 5 to sqrt(n) with a step of 6
    // this is because all prime numbers greater than 3 can be written in the form of 6k ± 1
    // where k is a positive integer
    // this is because all prime numbers greater than 3 are of the form 6k ± 1
    // so we can check if n is divisible by any number from 5 to sqrt(n) with a step of 6
    // if n is divisible by any number, then it is not prime
    // if n is not divisible by any number, then it is prime
    // this method is more efficient than the previous one
    // because it reduces the number of iterations by skipping even numbers and multiples of 3
    // and it has a time complexity of O(sqrt(n))
    // and a space complexity of O(1)
    // this method is also known as the 6k ± 1 optimization
    // it works because all prime numbers greater than 3 can be written in the form of 6k ± 1
    // where k is a positive integer
    // so we can check if n is divisible by any number from 5 to sqrt(n) with a step of 6
    // if n is divisible by any number, then it is not prime    
    public static boolean isPrimeOptimized2(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

}       

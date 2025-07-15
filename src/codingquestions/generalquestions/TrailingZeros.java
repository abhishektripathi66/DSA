package codingquestions.generalquestions;

public class TrailingZeros {
    // Add methods or main as needed
    public static void main(String[] args) {
        // System.out.println(countTrailingZeros(findfactorial(100)));
        System.out.println(countTrailingZeros1(100));

    }

    // time complexity: O(log(n)) Space complexity: O(1)
    public static int countTrailingZeros1(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res += n / i;
        }
        return res;
    }

    // time complexity: O(n) Space complexity: O(1)
    public static int findfactorial(int n) {
        int a = 1;
        for (int i = 2; i <= n; i++) {
            a *= i;
        }
        System.out.println(a);
        return a;
    }

    // time complexity: O(log(n)) Space complexity: O(1)
    public static int countTrailingZeros(int n) {
        int countTrailingZeros = 0;
        while (n % 10 == 0) {
            countTrailingZeros++;
            n /= 10;
        }
        System.out.println(countTrailingZeros);
        return countTrailingZeros;
    }
}
package codingquestions.generalquestions;

public class ComputePower {

    public static void main(String[] args) {
        // computePower(2, -3);
        // computepowereff(2,3);
        // System.out.println(cimputPowerIterative(2, -3));
        System.out.println(cimputPowerIterative(2, 3));
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static void computePower(int x, int n) {
        int a = 1;
        if (n == 0) {
            System.out.println(1);
            return;
        } else if (n < 0) {
            for (int i = 0; i < -n; i++) {
                a /= x;
            }
            System.out.println(a);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                a *= x;
            }
            System.out.println(a);
            return;
        }

    }

    // time complexity: O(log n)
    // space complexity: O(log n)
    public static double computepowereff(int x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / computepowereff(x, -n);
        double val = computepowereff(x, n / 2);
        if (n % 2 == 0) {

            return val * val;
        } else {
            return x * val;
        }
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    // we are using the bits to operate on the power
    //converting the power to binary and then using the bits to calculate the power
    // this is also known as exponentiation by squaring 
    public static double cimputPowerIterative(int x, int n) {
        double result = 1;
        boolean isNegative = n < 0;
        n = Math.abs(n);
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            n = n / 2;
            x *= x;
        }
        if (isNegative) {
            return 1 / result;
        } else {
            return result;
        }
    }
}
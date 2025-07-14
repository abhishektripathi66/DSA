package codingquestions.recursion;

public class Factorial {

    /**
     *
     */
    public static void main(String[] args) {
        var f = new factorial();
        var x = f.factorialpart(10);
        System.out.println(x);
    }

    public int factorialPart(int n) {
        System.out.println(n);
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        return n * factorialPart(n - 1);
    }

    public int factorialTailRecursive(int n, int k) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return k;
        return factorialTailRecursive(n - 1, n * k);
    }
}
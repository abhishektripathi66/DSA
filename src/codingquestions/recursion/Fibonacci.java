package codingquestions.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        var f = new Fibonacci();
        var fi = f.fibonacciPart(8);
        System.out.println(fi);
    }

    public int fibonacciPart(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;
        return fibonacciPart(n - 1) + fibonacciPart(n - 2);
    }
}
package algorithms.recursion;

/**
 * Provides a recursive approach to calculate the Fibonacci sequence.
 */
public class Fibonacci {
    
    /**
     * Calculates the nth Fibonacci number recursively.
     * 
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    /**
     * Main method to test the Fibonacci calculation.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Fibonacci ob = new Fibonacci();
        System.out.println(ob.fibo(2));
    }
}

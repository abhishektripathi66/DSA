package algorithms.recursion;

/**
 * Provides a recursive approach to calculate the factorial of a given number.
 */
public class Factorial {
    
    /**
     * Calculates the factorial of a number recursively.
     * 
     * @param n the number to calculate the factorial for
     * @return the factorial of n
     */
    static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }
    
    /**
     * Main method to test the factorial calculation.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fact(5)); 
    }
}
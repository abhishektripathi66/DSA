// package FibonacciSearch;

public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int x){
        int n = arr.length;

        // Initialize fibonacci numbers
        int fib2 = 0;
        int fib1 = 1;
        int fib = fib1 + fib2;

        // Find the smallest fibonacci number greater than or equal to n
        while (fib < n){
            fib2 = fib1;
            fib1 = fib;
            fib = fib1 + fib2;
        }

        // Marks the beginning of the search
        int offset = -1;

        // While there are elements to be inspected
        while (fib > 1){
            // Calculates the index to compare
            int i = Math.min(offset + fib2, n - 1);

            // If the element is on the right
            if (arr[i] < x){
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } // If the element is on the left 
            else if (arr[i] > x){
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            } //Element Found 
            else {
                return i;
            }
        }

        // Checks de last element
        if (fib1 == 1 && arr[offset + 1] == x){
            return offset + 1;
        }

        // Element not found
        return -1;
    }


    public static void main(String[] args){
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100}; // Sorted array
        int x = 80; // Element to be searched

        int index = fibonacciSearch(arr, x); // Search the element

        // Print the result
        if (index != -1){
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}

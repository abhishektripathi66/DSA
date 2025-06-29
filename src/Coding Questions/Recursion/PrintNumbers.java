public class PrintNumbers {
    // The tail recursive approach is used here to print numbers from N to 1 using recursion.
    // the tail recursive approach takes less time and space than the normal recursive approach.
    // tail recursion is a special case of recursion where the recursive call is the last operation in the function.
    public static void main(String[] args) {
        System.out.println("Printing numbers from 1 to N using recursion:");
        printNumbers1toN(5);
        System.out.println("Printing numbers from N to 1 using recursion:");
        printNumbersNto1(5);
        System.out.println("Printing numbers from 1 to N using Tail recursion:");
        printNumbers1toNTailRecursive(1,5);
    }

    // Time complexity: O(n)
    // Space complexity: O(n) due to recursion stack
    public static void printNumbers1toN(int n){
        if(n<=0){
            return;
        }
        printNumbers1toN(n-1);
        System.out.println(n);
    }

    // Time complexity: O(n)
    // Space complexity: O(n) due to recursion stack
    // in the tail recursive approach, the recursive call is the last operation in the function.
    // This allows the compiler to optimize the recursion and avoid creating a new stack frame for each
    // recursive call, which reduces the space complexity.
    public static void printNumbersNto1(int n){
        if(n<=0){
            return;
        }
        System.out.println(n);
        printNumbersNto1(n-1);
        
    }

    public static void printNumbers1toNTailRecursive(int current,int n){
        if(current >n){
            return;
        }
        System.out.println(current);
        printNumbers1toNTailRecursive(current+1, n);
    }
    
}

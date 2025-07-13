public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(powerof2(16)); // true
        System.out.println(powerof2Bitwise(16)); // true
        System.out.println(powerof2(19)); // false
         System.out.println(powerof2Bitwise(0)); // false
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    public static boolean powerof2(int n){
        if(n <= 0) return false;
        while(n>1){
            if(n%2!=0) return false;
            n=n/2;
        }
        return true;
    }
    
    // time complexity: O(1)
    // space complexity: O(1)
    public static boolean powerof2Bitwise(int n) {
       
        return (n&n & (n - 1)) == 0; // Check if n is a power of 2 using bitwise operation
    }
}

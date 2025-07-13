public class CountSetBits {

    public static void main(String[] args) {
        System.out.println(countSetBitsEfficient(10)); // Output: 2
        System.out.println(countSetBits(10)); // Output: 2
        System.out.println(countSetBitsUsingTable(10)); // Output: 2
    }

    public static int[] tbl = new int[256];

    public static void init() {
        for (int i = 0; i < 256; i++) {
            tbl[i] = (i & 1) + tbl[i >> 1];
        }
    }
    static {
        init(); // Initialize the lookup table
    }

    // time complexity: O(1)
    // space complexity: O(1)
    public static int countSetBitsUsingTable(int n){
        return tbl[n&255] +tbl[(n>>8)&255] + tbl[(n>>16)&255] + tbl[(n>>24)&255];
    }
    

    // time complexity: O(log n)
    // space complexity: O(1)
    public static int countSetBitsEfficient(int n){
        int count=0;
        while(n>0){
            count+=n&1;
            n=n>>1;
        }
        return count; // Return the count of set bits
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
             // Clear the least significant bit set
            if((n&2)==1) // we can also use count+=n&1;
                count++;
            n/=2;
        }
        return count; // Return the count of set bits
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    public static int countSetBitsEfficient1(int n) {
        int count = 0;
        while (n > 0) {
             // Clear the least significant bit set
            n=n&(n-1); // This operation clears the least significant bit set
            count++;
        }
        return count; // Return the count of set bits
    }

    // time complexity: O(log n)
    // space complexity: O(1)
    public static int countSetBitsEfficient2(int n) {
        int count = 0;
        while (n > 0) {
            // Clear the least significant bit set
            n = n & (n - 1); // This operation clears the least significant bit set
            count++;
        }
        return count; // Return the count of set bits
    }
}

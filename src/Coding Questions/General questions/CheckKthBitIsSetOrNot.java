public class CheckKthBitIsSetOrNot {

    public static void main(String[] args) {
        System.out.println(isKthBitSet(10, 2));
        System.out.println(isKthBitSetEfficient(10, 2));
        System.out.println(isKthBitSet1(10, 2));
        System.out.println(isKthBitSetEfficient1(10, 2));
    }

    public static boolean isKthBitSetEfficient(int n, int k){
        
            return (n & (1 << (k - 1))) != 0; // Check if the k-th bit is set
        
    }

    public static boolean isKthBitSetEfficient1(int n, int k){
        
            return (n>>k-1 &1) != 0; // Check if the k-th bit is set
        
    }

    public static boolean isKthBitSet(int n, int k) {
        return (n & (int)Math.pow(2,k-1)) != 0; // Check if the k-th bit is set
    }

    public static boolean isKthBitSet1(int n, int k) {
        for(int i=0;i<k-1;i++){
            n=n/2;
        }
        return (n & 1)!=0; // Check if the k-th bit is set
    }
    
}

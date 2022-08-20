import java.math.BigInteger;

public class FindSqrt {
    

    public static void main(String[] args) {
        

    }

    public int mySqrt(int x) {
        BigInteger c = BigInteger.valueOf(x);
        return c.sqrt().intValue();
    }

    public int mySqrt2(int x) {
        if(x == 0){
            return 0;
        }
        int start = 1;
        int end = x;
        int ans = 0;
        while(start <= end){
            int mid = start + (end-start)/2;
			//instead of mid*mid we are giving x/mid to tackle overflow of integer range when multiplying with bigger numbers
            if(mid <= x/mid){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
}

package algorithms.searchingalogrithms.binarysearch;
/**
 * we find the nearest squareroot of the given number
 * like the nearest squareroot of 7 is 4, and 9 is 3.
 * @param a
 * @return
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(sqrt(15));
    }

    public static int sqrt(int a){
        int low=1,high=a,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int sq = mid*mid;
            if(sq>a) high = mid-1;
            else if(sq<a){
                low = mid+1;
                ans=mid;
            } 
            else return mid;
        }
        return ans;
    }
    
}

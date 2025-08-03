package codingquestions.leetcode;

public class TrionicArrayI {

    public static void main(String[] args) {
        int[] arr = {5,9,1,7};
        System.out.println(isTrionic(arr));
    }
    
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;

        for(int p=1;p<n-2;p++){
            if(!isStrictlyIncreasing(nums,0,p)) continue;
            for(int q=p+1;q<n-1;q++){
                if(isStrictlyDecreasing(nums,p,q) && isStrictlyIncreasing(nums,q,n-1)) return true;
            }
        }
        return false;
    }

    private static boolean isStrictlyIncreasing(int[] nums,int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]>=nums[i+1]) return false;
        }
        return true;
    }

    private static boolean isStrictlyDecreasing(int[] nums, int start, int end){
        for(int i=start;i<end;i++){
            if(nums[i]<=nums[i+1]) return false; 
        }
        return true;
    }
}

package ArrayInterviewQuestion;

public class SlidingWindowTechnique {
    
    public static void main(String[] args) {
        System.out.println(maxsum(new int[]{1,8,30,-5,20,7}, 3)); // Output: 24
    }

    public static int maxsum(int[] arr, int k){
        int maxsum=0;
        int windosum=0;
        for(int i=0;i<k;i++){
            windosum+=arr[i];
        }
        maxsum=windosum;
        for(int i=k;i<arr.length;i++){
            windosum+=arr[i]-arr[i-k];
            maxsum=Math.max(maxsum, windosum);
        }
        return maxsum;
    
    
    }
}

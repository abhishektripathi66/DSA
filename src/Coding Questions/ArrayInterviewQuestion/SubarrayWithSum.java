package ArrayInterviewQuestion;

public class SubarrayWithSum {

    public static void main(String[] args) {
        System.out.println(subarraysum(new int[]{1,4,20,3,10,5}, 33)); // Output: true
    }

    public static boolean subarraysum(int[] arr, int sum){
        int sum1=0;
        int j=0;
        for(int i=0;i<arr.length;i++){
            sum1+=arr[i];
            
            while(sum1>sum){
                sum1-=arr[j++];
            }
            if(sum1==sum) return true;
        }
        return false;
    }
    
}

package ArrayInterviewQuestion;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{8,3,4,8,8}));
        System.out.println(findmajority1(new int[]{8,3,4,8,8}));
    }

    public static int findMajority(int[] nums){
        int count =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])
                count++;
            }
            
            if(count> nums.length/2){
                return nums[i];
            }
               

        }
        return -1;
    }

    public static int findmajority1(int[] arr){
        int res=0,count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[res]==arr[i]) count++;
            else count--;
            if(count==0){
                res=i;
                count =1;
            }
        }
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[res]) count++;

        }
        if(count>arr.length/2) return arr[res];
        return -1;
    }
    
}

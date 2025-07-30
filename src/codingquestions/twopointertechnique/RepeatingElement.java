package codingquestions.twopointertechnique;

public class RepeatingElement {

    public static void main(String[] args) {
        int[] arr = {0,2,1,3,2,2};
        System.out.println(findRepeat(arr));
        int[] arr1 ={0,0,0};
        System.out.println(findRepeat(arr1));
    }

    // O(n) and O(1) space complexity
    public static int findRepeat(int[] arr){
            int[] a = new int[arr.length];
            for(int j:arr){
                a[j]++;
                if(a[j]>1) return j;
            }
            return -1;
        
    }

    public static int findRepeatingUsingFastSlowApproach(int[] arr){
        int slow=arr[0]+1, fast = arr[0]+1;
        do{
            slow = arr[slow]+1;
            fast=arr[arr[fast]]+1;
        }
        while(slow!=fast);
        slow=arr[0]+1;
        while(slow!=fast){
            slow=arr[slow]+1;
            fast = arr[fast]+1;
        }
        return slow-1;
    }
    
}

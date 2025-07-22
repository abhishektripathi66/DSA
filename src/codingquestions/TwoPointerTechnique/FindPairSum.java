package codingquestions.TwoPointerTechnique;
// this is best used only when the array is sorted.
public class FindPairSum {

    public static void main(String[] args) {
        int[] arr={2,4,8,9,11,12,20,30};
        System.out.println(findsum(arr, 23));
    }


    public static boolean findsum(int[] arr, int sum){
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==sum) return true;
            if(arr[i]+arr[j]>sum) j--;
            else i++;
        }
        return false;
    }
    
}

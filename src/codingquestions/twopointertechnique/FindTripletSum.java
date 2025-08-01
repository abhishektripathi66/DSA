package codingquestions.twopointertechnique;

public class FindTripletSum {

    public static void main(String[] args) {
        int[] arr = {2,3,4,8,9,20,40};
        System.out.println(isTriplet(arr, 32));

    }

    public static boolean isTriplet(int[] arr, int sum){
        for(int i=0;i<arr.length-2;i++){
            if(pairsum(arr, i+1, sum-arr[i])) return true;
        }
        return false;
    }

    public static boolean pairsum(int[] arr, int start, int sum){
        int i=start,j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==sum) return true;
            else if(arr[i]+arr[j]>sum) j--;
            else i++;
        }
        return false;
    }

  

    
    
}

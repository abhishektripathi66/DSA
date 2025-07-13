public class MaximumValue {

    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,8,1};
        System.out.println(maximumDifference(arr));
    }

    public static int maximumDifference(int[] arr){
            int res = arr[1]-arr[0],minval=arr[0];
            for(int i=1;i<arr.length;i++){
                res = Math.max(res,arr[i]-minval);
                minval=Math.min(minval,arr[i]);
            }
            return res;
        

    }
    
}

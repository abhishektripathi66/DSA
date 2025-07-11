public class MaximumCircularSubarraySum {
    

    public static void main(String[] args) {
        
        System.out.println(naivemethod(new int[]{5,-2,3,4}));

    }

    public static int naivemethod(int[] arr){

        int count=0,countmax=0;
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            count=arr[i];
            if(j>arr.length-1) j=0;
            while(j!=i){
                
                count+=arr[j];
                countmax=Math.max(count,countmax);
                j++;
                if(j>arr.length-1) j=0;
            }
            countmax=Math.max(count,countmax);
        }
        return countmax;


    }

    public static int effmethod(int[] arr){
        //normal sum
        int res = MaximumSumSubarray.maxSumsubarrayeffsol1(arr);

        if(res<0) return res;

        //circular sum
        int arr_sum=0;
        //getting the array sum and inverting the array elements
        for(int i=0;i<arr.length;i++){
            arr_sum+=arr[i];
            arr[i]=-arr[i];
        }

        int res1 = MaximumSumSubarray.maxSumsubarrayeffsol1(arr);
        int max_circular = arr_sum+ res1;
        return Math.max(max_circular,res);




    }
}

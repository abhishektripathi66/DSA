public class MaximumSumSubarray {

    public static void main(String[] args) {
        System.out.println(maxsumSubarrayNaiveSolution(new int[]{2,3,-8,7,-1,2,3}));
        System.out.println(maxSumsubarrayeffsol(new int[]{2,3,-8,7,-1,2,3}));
    }

    //time complexity o(n*n)
    public static int maxsumSubarrayNaiveSolution(int[] arr){

        int res=arr[0];
        for(int i=0;i<arr.length;i++){
            int curr=0;
            for(int j=i;j<arr.length;j++){
                curr+=arr[j];
                res=Math.max(res,curr);
            }
        }
        return res;
    }

    public static int maxSumsubarrayeffsol(int[] arr){
        int[] maxarray = new int[arr.length];
        maxarray[0]=arr[0];
        int res = arr[0];
        for(int i=1;i<arr.length;i++){
            maxarray[i]=Math.max(maxarray[i-1]+arr[i],arr[i]);
            res = Math.max(res,maxarray[i]);
        }
        return res;
    }

    public static int maxSumsubarrayeffsol1(int[] arr){
        
        int maxarray =arr[0];
        int res = arr[0];
        for(int i=1;i<arr.length;i++){
            maxarray=Math.max(maxarray+arr[i],arr[i]);
            res = Math.max(res,maxarray);
        }
        return res;
    }
    
}



/*
 * Solution to calculate max water which can be gathered in given array of blocks.
 * It checks from each block and calculate amout of water can be stored, adds up value in final result.
 * 
 * 
 * Time Complexity: O(n)
 * Auxilliary Space Complexity: O(1)
 * 
 * Example: [10, 3, 15, 7, 9, 8] → Maximum Water = 9
 */

public class TrapRainWater {
    public static void main(String[] args){
        
        int[] blocks =  {10, 3, 15, 7, 9, 8};

        System.out.println("maxWater : "+maxWater(blocks));
        System.out.println("maxWater : "+findwater(blocks));
    }

    private static int maxWater(int[] arr){

        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];

        //filling leftMax array
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(arr[i-1], leftMax[i-1]);
        }

        //filling rightMax array
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(arr[i+1], rightMax[i+1]);
        }

        int maxWater = 0;

        //water can be gathered from second block to second last block
        for(int i=1; i<n-1; i++){
            int minOfBothMax = Math.min(leftMax[i], rightMax[i]);
            if(minOfBothMax > arr[i])
                maxWater += minOfBothMax - arr[i];
        }

        return maxWater;
    }


    public static int findwater(int[] arr){
        int res=0;
        for(int i=1;i<arr.length-1;i++){
            int lmax=arr[i];
            for(int j=0;j<i;j++){
                lmax=Math.max(lmax,arr[j]);
            }
            int rmax=arr[i];
            for(int j=i+1;j<arr.length;j++){
                rmax=Math.max(rmax,arr[j]);
            }
            res+= Math.min(rmax,lmax)-arr[i];
        }
        return res;
    }

    public static int findwatereff(int[] arr){
        int lmax[] = new int[arr.length];
        int rmax[] = new int[arr.length];
        int res=0;
        lmax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            lmax[i]=Math.max(lmax[i-1],arr[i]);
        }
        rmax[rmax.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rmax[i]=Math.max(arr[i],rmax[i+1]);
        }
        for(int i=1;i<arr.length-1;i++){
            res+=Math.min(rmax[i],lmax[i])+arr[i];
        }

       return res;
    }
}

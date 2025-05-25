package ArrayInterviewQuestion;

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
}

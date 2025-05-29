package ArrayInterviewQuestion;

/*
 * Given prices of stock.
 * Have to find out maximum profit that can be obtained.
 * Can be done by adding postivite differences.
 * 
 * 
 * Time Complexity: O(n)
 * Auxilliary Space Complexity: O(1)
 * 
 * Example: [5, 2, 7, 9, 4] → Maximum Profit = 7
 */

public class StockBuySell {
    public static void main(String[] args){
        int[] stockDailyPrice = {5, 2, 7, 9, 4};
        System.out.println("Max Profil : "+findMaxProfit(stockDailyPrice));
    }

    private static int findMaxProfit(int[] arr){
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++ ){
            
            //add diff only if curr price is greater than previous one
            if(arr[i] > arr[i-1])
                maxProfit += (arr[i] - arr[i-1]);
        }

        return maxProfit;
    }
}
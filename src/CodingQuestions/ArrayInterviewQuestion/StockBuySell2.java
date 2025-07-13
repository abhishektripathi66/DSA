public class StockBuySell2 {
    
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,5,3,8,12}, 0, 5));
        System.out.println(findMaxProfiteff(new int[]{1,5,3,8,12}));
    }

    public static int maxProfit(int price[], int start,int end){
        if(end<=start) return 0;
        int profit=0;
        for(int i=start;i<end;i++){
            for(int j=i+1;j<end;j++){
                if(price[i]<price[j]){
                    int curr_profit = price[j]-price[i]+
                                        maxProfit(price, start, i-1)+
                                        maxProfit(price, j+1, end);
                    profit= Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    private static int findMaxProfiteff(int[] arr){
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++ ){
            
            //add diff only if curr price is greater than previous one
            if(arr[i] > arr[i-1])
                maxProfit += (arr[i] - arr[i-1]);
        }

        return maxProfit;
    }
}

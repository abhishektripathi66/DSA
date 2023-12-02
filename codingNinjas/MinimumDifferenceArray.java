package codingNinjas;

public class MinimumDifferenceArray {
    
    
    static int minDiff(int n, int[] arr) {
        // Write your code here.
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(min==0) return min;
            for(int j=i+1;j<n;j++){
                int k=arr[i]-arr[j];
                if(k<0) k=-k;
                if(min>k) min=k;
            }
        }
        return min;
}

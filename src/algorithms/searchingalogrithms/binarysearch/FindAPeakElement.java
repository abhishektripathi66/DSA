package algorithms.searchingalogrithms.binarysearch;

public class FindAPeakElement {
    
    public static void main(String[] args) {
        int[] arr = {120,80,40,30,20,50,60};
        System.out.println(getPeak(arr, arr.length));
        System.out.println(getPeakUsingBinarySearch(arr, arr.length));
    }

    public static int getPeak(int[] arr, int n){
        if(n==1) return arr[0];
        if(arr[0]>=arr[1]) return arr[0];
        if(arr[n-1]>=arr[n-2]) return arr[n-1];
        for(int i=1;i<n-1;i++){
            if(arr[i]>=arr[i-1] && arr[i]>=arr[i+1]) return arr[i];
        }
        return -1;
    }

    public static int getPeakUsingBinarySearch(int[] arr, int n){
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || arr[mid-1] <= arr[mid]) && (mid==n-1 || arr[mid+1]<=arr[mid])) return arr[mid];
            if(mid>0 && arr[mid-1]>=arr[mid]) high =mid-1;
            else low = mid+1;
        }
        return -1;
    }
}

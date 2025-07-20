package algorithms.searchingalogrithms.binarysearch;

public class SearchInASortedRotatedArray {
    
    // in the sortedrotatedarray the one half is always sorted so we only scan the one half and skip the other half
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,10,30,40};
        System.out.println(searchRotatedArray(arr, 10));
        System.out.println(searcheff(arr, 10));
    }

    
    public static int searchRotatedArray(int[] arr, int x){
        System.out.println(arr.length/2);
        if(arr[arr.length/2]==x) return arr.length/2;
        if(arr[arr.length/2]>arr[0]) {
            if(x>=arr[0] && x<arr[arr.length/2]){
               return SearchInAnInfinteSortedArray.binarysearch(arr, 0, arr.length/2, x);
            }
        }
        return SearchInAnInfinteSortedArray.binarysearch(arr,(arr.length/2)+1,arr.length-1,x);
    }

    public static int searcheff(int[] arr, int x){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]>=arr[low]){
                if(x>=arr[low] && x<arr[mid]) high =mid-1;
                else low=mid+1;
            }
            else{
                if(x>arr[mid] && x<arr[arr.length-1])
                low=mid+1;
                else 
                high=mid-1;
            }
        }
        return -1;
    }

}

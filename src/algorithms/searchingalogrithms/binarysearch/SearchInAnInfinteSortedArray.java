package algorithms.searchingalogrithms.binarysearch;

// also know as Unbounded binary search
public class SearchInAnInfinteSortedArray {
    
public static void main(String[] args) {
    int[] arr = {1,2,3,5,6,8,10,13,15,17,20,23,26,28,30,35,39,40};
    System.out.println(search(arr,10));
    System.out.println(searcheff(arr,10));
}

/**
 * arr[]={1,10,200,....}, x=10
 */

 public static int search(int[] arr, int x){
    int i=0;
    while(true){
        if(arr[i]==x) return i;
        if(arr[i]>x) return -1;
        i++;
    }
 }

 // Efficient solution using binary search, but we cannot apply it.
    public static int searcheff(int[] arr, int x){
        if(arr[0]==x) return 0;
        int i=1;
        while(arr[i]<x){
            i=i*2;
            if(arr[i]==x) return i;
        }
        return binarysearch(arr,i/2+1,i,x);
    }

    public static  int binarysearch(int[] arr, int low, int high, int x){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }


}

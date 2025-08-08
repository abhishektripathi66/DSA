package codingquestions.problemsonsorting.quicksort;

public class KthSmallestElement {

    public static void main(String[] args) {
        
    }

    public static int findKthSmallest(int[] arr, int k){
        int low =0,high= arr.length-1;
            while(low<=high){
            int p = partition(arr, low, high);
            if(p==k-1) return arr[p];
            else if(p>k-1) high=p-1;
            else low=p+1;
            }
            return -1;
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i=start-1,j=end+1;
        while(true){
            do{
                i++;
            }while(pivot>arr[i]);
            do{
                j--;
            }while(pivot<arr[j]);
            if(i>=j) return j;
            int temp =arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
    
}
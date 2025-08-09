package algorithms.sortingalgorithms.quicksort;

import java.util.Arrays;

public class ParitionFunction {

    public static void main(String[] args) {
        int[] arr ={5,13,6,9,12,11,8};
        partitionNaive(arr, 0, 6, 6); // p means all the elements less than the element at that index should be placed at left and greater elements at right
        System.out.println(Arrays.toString(arr));
        LumutoPartition(arr, 0, 6);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {70,60,80,40,30};
        LumutoPartition(arr1, 0, 4);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {30,40,25,50,80};
        LumutoPartition(arr2, 0, 4);
        System.out.println(Arrays.toString(arr2));
        // when pivot is not the last element in the lomuto partition we would then swap it with the last element
    }

    public static void partitionNaive(int[] arr, int l, int h, int p){
        int[] temp = new int[h-l+1];int index=0;
        for(int i=l;i<=h;i++){
            if(arr[i]<=arr[p] && i!=p)
                temp[index++]=arr[i];
        }
        temp[index++] = arr[p];
        for(int i=l;i<=h;i++)
            if(arr[i]>arr[p] )
                temp[index++]=arr[i];   
        for(int i=l;i<=h;i++){
            arr[i]=temp[i-l];
        }

    }

    // in this we partitioning method we would be assuming that the pivot is always at the last index i.e, h.
    // time complexoty O(n) O(1) space complexity
    // in this if the pivot is any other element then we would be swaping the h element with that particular element and then go ahead with the same process
    public static int LumutoPartition(int[] arr, int low, int high){
            int pivot = arr[high];
            int i=low-1;
            for(int j=low;j<=high-1;j++){
                if(arr[j]<pivot){
                    i++; 
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            int temp = arr[i+1];
            arr[i+1]=arr[high];
            arr[high]=temp;
            return i+1;
    }

    // in this partiitoning technique we would be considering the first element as the pivot element
    // in this if the pivot is any other element then we would be swaping the h element with that particular element and then go ahead with the same process
    // in this partition the pivot is not at the exact  position, because all the elements that are less than are in the left part and all the elements greater then or equal to the pivot elemnt are in the right part
    // this is not stable
    public static int HoarePartition(int arr[], int l,int h){
            int pivot = arr[l];
            int i=l-1,j=h+1;
            while(true){
                do{
                    i++;
                }while(arr[i]<pivot);
                do{
                    j--;
                }while(arr[j]>pivot);
                if(i>=j) return j;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
    }
    
}

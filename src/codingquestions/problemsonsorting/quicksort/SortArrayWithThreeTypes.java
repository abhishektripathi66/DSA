package codingquestions.problemsonsorting.quicksort;

import java.util.Arrays;

public class SortArrayWithThreeTypes {

    public static void main(String[] args) {
        int[] arr = {0,1,2,1,1,2};
        Sort0s1s2s(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {2,1,2,20,10,20,1};
        Sort3Way(arr1,2);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {10,5,6,3,20,9,40};
        int[] range ={5,10};
        SortaroundRange(arr2,range);
        System.out.println(Arrays.toString(arr2));

    }
    // Dutch National Flag Algorithm is the efficient Solution
    public static void Sort0s1s2s(int[] arr){
        int low=0,high=arr.length-1,mid=0;
        while(mid<=high){
            if(arr[mid]==0){
                arr[mid]=arr[low];
                arr[low]=0;
                low++;mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }

    public static void Sort3Way(int[] arr,int pivot){
        int low=0,high=arr.length-1,mid=0;
        while(mid<=high){
            if(arr[mid]<pivot){
                int temp = arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;mid++;
            }
            else if(arr[mid]==pivot){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }

    public static void SortaroundRange(int[] arr,int[] range){
        int low=0,high=arr.length-1,mid=0;
        while(mid<=high){
            if(arr[mid]<range[0]){
                int temp = arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;mid++;
            }
            else if(arr[mid]>=range[0]  && arr[mid]<=range[1]){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
    
}

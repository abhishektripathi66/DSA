package codingquestions.arrayinterviewquestion;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {10,20,35};
        int[] arr2 = {5,50,50};
        mergeTwoSortedArray(arr1, arr2);
        System.out.println("Sorted the single array");
        int[] arr3 = {10,15,20,40,8,11,55};
        SortTheArray(arr3, 0, 3, 6);
    }

    public static void mergeTwoSortedArray(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j])
            System.out.println(arr1[i++]);
            else
            System.out.println(arr2[j++]);
        }
        while(i<arr1.length){
            System.out.println(arr1[i++]);
        }
        while(j<arr2.length){
            System.out.println(arr2[j++]);
        }
    }

    // sort the complete array, where 0 to mid is sorted and mid to high is sorted
    public static void SortTheArray(int[] arr, int low, int mid, int high){
        int[] left = new int[mid-low+1];
        int[] right = new int[high-mid];
        for(int i=low;i<=high;i++){
            if(i<mid+1) left[i-low]=arr[i];
            else right[i-mid-1]=arr[i];
        }

        int i=0,j=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j])
            arr[i+j]=left[i++];
            else
            arr[i+j]=right[j++];
        }
        while(i<left.length){
            arr[i+j]=left[i++];
        }
        while(j<right.length){
            arr[i+j]=right[j++];
        }
       System.out.println(Arrays.toString(arr));
    }
    
}

package algorithms.sortingalgorithms.mergesort;

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
        int n1 = mid-low+1, n2 = high-mid;
        int[] left=new int[n1],right= new int[n2];
        for(int i=0;i<n1;i++) left[i]=arr[low+i];
        for(int i=0;i<n2;i++) right[i]=arr[mid+i+1];
        int i=0,j=0,k=low;
        while(i<n1 && j<n2){
            if(left[i]<=right[j])
            arr[k++]=left[i++];
            else
            arr[k++]=right[j++];
        }
        while(i<n1){
            arr[k++]=left[i++];
        }
        while(j<n2){
            arr[k++]=right[j++];
        }
       
    }
    
}

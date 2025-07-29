package codingquestions.arrayinterviewquestion;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {10,20,35};
        int[] arr2 = {5,50,50};
        mergeTwoSortedArray(arr1, arr2);
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
        
    }
    
}

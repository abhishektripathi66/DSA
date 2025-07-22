package codingquestions.TwoPointerTechnique;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = {5,15,25,35,45};
        System.out.println(medianofTwoSortedArrays(arr1, arr2));
        int[] arr3 ={1,2,3,4,5,6};
        int[] arr4={10,20,30,40,50};
        System.out.println(medianofTwoSortedArrays(arr3,arr4));
    }

    public static double medianofTwoSortedArrays(int[] arr1,int[] arr2){

        int i=0,j=0,k=0;
        int[] arr = new int[arr1.length+arr2.length];
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr[k++]=arr2[j++];
            }
            else if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }
            else{
                arr[k++]=arr1[i++];
                arr[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
        while(j<arr2.length){
            arr[k++]=arr2[j++];
        }

        if(arr.length%2==0){
            return (arr[arr.length/2-1]+arr[arr.length/2])/2.0;
        }
        else{
            return arr[arr.length/2];
        }

    }
    
}

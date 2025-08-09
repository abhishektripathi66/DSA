package codingquestions.problemsonsorting.quicksort;

import java.util.Arrays;

public class SortArrayWithTwoTypes {

    public static void main(String[] args) {
        int[] arr = {-12,18,-10,15};
        sortPositiveAndNegative(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {15,14,13,12};
        sortEvenandOdd(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {0,1,1,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,0};
        sortBinaryArray(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void sortPositiveAndNegative(int[] arr){
        int i=-1,j=arr.length;
        while(true){
            do{i++;}while(arr[i]<0);
            do{j--;}while(arr[j]>=0);
            if(i>=j) return;
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    public static void sortEvenandOdd(int[] arr){
        int i=-1,j=arr.length;
        while(true){
            do{i++;}while(arr[i]%2==0);
            do{j--;}while(arr[j]%2!=0);
            if(i>=j) return;
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

        }
    }

    public static void sortBinaryArray(int[] arr){
        int i=-1,j=arr.length;
        while(true){
            do{i++;}while(arr[i]==0);
            do{j--;}while(arr[j]%2==1);
            if(i>=j) return;
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

        }
    }
    
}

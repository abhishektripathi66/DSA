package codingquestions.problemsonsorting.quicksort;

import java.util.Arrays;

public class MergeOverlappingIntervals {
    
    public static void main(String[] args) {
        int[][] arr = {{5,10},{3,15},{18,30},{2,7}};
        mergeIntervals(arr);
    }


    // sort by start time in increasing order and then find the value.
    public static void mergeIntervals(int[][] arr){
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int res =0;
        for(int i=1;i<arr.length;i++){
            if(arr[res][1]>=arr[i][0]){
                arr[res][1]=Math.max(arr[res][1],arr[i][1]);
                arr[res][0]=Math.min(arr[res][0],arr[i][0]);
            }
            else{
                res++; arr[res]=arr[i];
            }

        }
        
        for(int i=0;i<=res;i++){
            System.out.println(arr[i][0]+" : "+arr[i][1]);
        }
        
    }
}


package algorithms.sortingalgorithms.cyclesort;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int[] arr = {20,40,50,10,30};
        cycleSortDistinct(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {20,40,50,10,20};
        cycleSortWithDuplicates(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void cycleSortDistinct(int[] arr){
        int countswap =0;
        for(int cs =0;cs<arr.length-1;cs++){
            int item = arr[cs];
            int pos=cs;
            for(int i=cs+1;i<arr.length;i++){
                if(arr[i]<item){
                    pos++;
                }
            }
            // If item is already in correct position, skip
            // if (pos == cs) {
            //     continue;
            // }

            // // Skip duplicates
            // while (item == arr[pos]) {
            //     pos++;
            // }
            // if(pos!=cs){
            int temp = item;
            item = arr[pos];
            arr[pos]=temp;
            // }
            countswap++;
            while(pos != cs){
                pos = cs;
                for(int i=cs+1;i<arr.length;i++)
                    if(arr[i]<item) pos++;
                
                    temp = item;
                    item = arr[pos];
                    arr[pos]=temp;
                    countswap++;
                
            }
            
        }
        System.out.println(countswap);
    }

    public static void cycleSortWithDuplicates(int[] arr){
        int countswap =0;
        for(int cs =0;cs<arr.length-1;cs++){
            int item = arr[cs];
            int pos=cs;
            for(int i=cs+1;i<arr.length;i++){
                if(arr[i]<item){
                    pos++;
                }
            }
            if (pos == cs) {
                continue;
            }
            while (item == arr[pos]) {
                pos++;
            }
            if (pos != cs) {
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
            countswap++;
            while(pos != cs){
                pos = cs;
                for(int i=cs+1;i<arr.length;i++){
                    if(arr[i]<item) pos++;
                }
                    int temp = item;
                    item = arr[pos];
                    arr[pos]=temp;
                    countswap++;
                
            }
            
        }
        System.out.println(countswap);
    }
    
}
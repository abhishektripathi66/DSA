
package algorithms.sortingalgorithms.cyclesort;

public class CycleSort {

    public static void main(String[] args) {
        
    }

    public static void cycleSortDistinct(int[] arr){
        for(int cs =0;cs<arr.length-1;cs++){
            int item = arr[cs];
            int pos=cs;
            for(int i=cs+1;i<arr.length;i++){
                if(arr[i]<item){
                    pos++;
                }
            }
            int temp = item;
            item = arr[pos];
            arr[pos]=temp;
            while(pos != cs){
                pos = cs;
                for(int i=cs+1;i<arr.length;i++){
                    if(arr[i]<item) pos++;
                    temp = item;
                    item = arr[pos];
                    arr[pos]=temp;

                }
            }
            
        }
    }
    
}
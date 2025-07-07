public class RemoveDuplicatesFromSortedArray {
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 4, 4, 5};
        int a = removeduplicates(arr);
        for(int i=0;i<a;i++){
            System.out.print(arr[i] + " ");
        }
    }

    //time complexity: O(n)
    //space complexity: O(1)
    public static int removeduplicates(int[] arr){
        int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }

}

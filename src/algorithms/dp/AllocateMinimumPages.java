package algorithms.dp;


public class AllocateMinimumPages {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int n = arr.length;
        System.out.println("Manimized maximum pages : "+allocateMinimumPagesRec(arr, n, k));
    }
    
    
    private static int allocateMinimumPagesRec(int[] arr, int n, int k){

        //all books go to one student
        if(k == 1)
            return sum(arr, 0, n-1);
        
        //only one book left 
        if(n == 1)
            return arr[0];
        
        int res = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            //first i books go to k-1 students, and the rest go to the last one
            res = Math.min(res, Math.max(allocateMinimumPagesRec(arr, i, k-1), sum(arr, i, n-1)));
        }

        //return the minimized res
        return res;
    }

    //utility method to count number of pages in given range
    private static int sum(int[] arr, int b, int e){
        int sum = 0;
        for(int i=b; i<=e; i++)
            sum += arr[i];
        return sum;
    }
}

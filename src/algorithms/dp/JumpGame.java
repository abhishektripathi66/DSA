package algorithms.dp;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 1};
        //int[] arr = {3, 4, 5, 2, 1};

        int  n = arr.length;

        int res = minJumpRec(0, arr, n);
        System.out.println("Min jumps : " + (res == Integer.MAX_VALUE ? -1 : res ));

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        res = minJumpMemo(0, arr, n, memo);
        System.out.println("Min jumps : " + (res == Integer.MAX_VALUE ? -1 : res ));

    }

    //Time Complexity: O(maxJumpLength^n), Space Complexity: O(n) for recursion stack
    private static int minJumpRec(int currIdx, int[] arr, int n){
        if(currIdx >= n-1) //reached end, no jumps required
            return 0;
        
        int res = Integer.MAX_VALUE;
        //take the min possible jump from upcoming steps and add +1 for curr jump
        for(int i = currIdx+1; i<=Math.min(currIdx + arr[currIdx], n-1); i++){ //min function used here to keep i within boundry range
            int sub_res = minJumpRec(i, arr, n);
            if(sub_res != Integer.MAX_VALUE)
                res = Math.min(res, sub_res+1);
        }

        return res;
    }

    //Time Complexity: O(n^2), n states × up to n transitions per state
    //Space Complexity: O(n)
    private static int minJumpMemo(int currIdx, int[] arr, int n, int[] memo){
        //Base case, when reached last index
        if(currIdx >= n-1)
            return 0;
        
        //return result if already computed for curr index
        if(memo[currIdx] != -1)
                return memo[currIdx];
        
        //try to take min possible value from next indexes 
        int res = Integer.MAX_VALUE;
        for(int i = currIdx+1; i<=Math.min(currIdx + arr[currIdx], n-1); i++){
            int sub_res = minJumpMemo(i, arr, n, memo);
            if(sub_res != Integer.MAX_VALUE)
                res = Math.min(res, sub_res+1);
        }

        //store and return result
        return memo[currIdx] = res;
    }

}

package algorithms.dp;

public class PalindromePartitioning {

    //minimum number of cuts required to make all strings palindrome
    public static void main(String[] args) {
        String s = "abbac";
        int n = s.length();
        System.out.println("Mimum cuts required : "+isPalindromeRec(s, 0, n-1));
    }
    
    private static int isPalindromeRec(String s, int i, int j){

        if(i>=j || isPalindrome(s, i, j))
            return 0;
        
        int res = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            //one cut made, check on the other two parts from cut
            res = Math.min(res, 1 + isPalindromeRec(s, i, k) + isPalindromeRec(s, k+1, j));
        }

        return res;
    }
    private static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}

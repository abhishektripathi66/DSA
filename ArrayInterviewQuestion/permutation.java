package ArrayInterviewQuestion;

import java.util.Arrays;

/*
 * Your are given two integer arrays. Write a program to check if they are permutation of each other.

Example

int[] array1 = {1,2,3,4,5};
int[] array2 = {5,1,2,3,4};
permutation(array1, array2)
Output

true
 */
public class permutation {
    public static void main(String[] args) {
        permutation permutations = new permutation();
        System.out.println(permutations.test(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}));
    }

    public boolean test(int[] ar1, int[] ar2){
        if(ar1.length!=ar2.length) return false;
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        for(int i=0;i<ar1.length;i++){
            if(ar1[i]!=ar2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean onlyForInt(int[] ar1,int[] ar2){
        if(ar1.length!=ar2.length) return false;
        int sum1=0;
        int sum2=0;
        int prod1=1;
        int prod2=1;
        for(int i=0;i<ar1.length;i++){
            sum1+=ar1[i];sum2+=ar2[i];prod1*=ar1[i];prod2*=ar2[i];
        }
        if(sum1==sum2 && prod1==prod2) return true;
        return false;
    }

}

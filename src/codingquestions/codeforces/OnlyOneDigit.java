package codingquestions.codeforces;

import java.util.Scanner;

public class OnlyOneDigit {
    
    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        int a = myObj.nextInt();
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = myObj.nextInt();
        }
        for (int i = 0; i < a; i++) {
            System.out.println(onlyonedigit(b[i]));
        }

    }

    public static int onlyonedigit(int n){
        int a=Integer.MAX_VALUE;
        while(n>0){
            int digit = n % 10;
            a=Math.min(a,digit);
            n /= 10; // Remove the last digit
        }
        return a;
    }


}

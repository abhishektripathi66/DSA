package codingquestions.codeforces;

import java.util.Scanner;

public class NoCasinoInMountain {

    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            int q = myObj.nextInt();
            for(int i = 0; i < q; i++) {
                int n = myObj.nextInt();
                int k = myObj.nextInt();
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = myObj.nextInt();
                }
                System.out.println("output "+noCasinoInMountain(n, k, a));
            }
        }
    }

    private static int noCasinoInMountain(int n, int k, int[] a) {
        int count =0;
        int j=0;
        for (int i = 0; i < n; i++) {
            if(j==k){
                count++;
                j=0;
            }
            else if (a[i] == 0) {
                j++;
            }
            else {
                j = 0;
            }
        
        }
        if(j==k){
                count++;
                j=0;
            }
        return count;
    }

    
}

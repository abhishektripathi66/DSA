package codingquestions.codeforces;

import java.util.Scanner;

public class RecyclingCentre {

    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            int a = myObj.nextInt();
            for (int i = 0; i < a; i++) {
                int c = myObj.nextInt();
                int d = myObj.nextInt();
                int[] b = new int[c];
                for(int j=0;j<c;j++){
                    b[j]=myObj.nextInt();
                }
                System.out.println(printCost(b,d));
            }
            
        }
    }

    private static int printCost(int[] cost, int c) {
        int coin=0;
        int mult2 =1;
        for(int i=0;i<cost.length;i++){
            System.out.println(cost[i]);
            if((cost[i]*mult2)>c){
                coin++;
            }
            mult2*=2;
        }
        return coin;
        
    }
    
}

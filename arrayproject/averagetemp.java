package arrayproject;

import java.util.Scanner;

public class averagetemp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Days temperature?");
        int numberOfDays = scanner.nextInt();
        int[] temp = new int[numberOfDays];
        int average =0;
        int sum=0;
        System.out.println("Enter the temparature of that many days");
        for(int i=0;i<numberOfDays;i++){
            temp[i]=scanner.nextInt();
            sum+=temp[i];
        }

        average = sum/numberOfDays;
        
        System.out.println("The average temparature is "+average);
        for(int i=0;i<numberOfDays;i++){
            if(temp[i]>average) System.out.println("Day "+(i+1)+"'s temperature is above average");
        }

    }
}

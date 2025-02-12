package GeneralQuestions;

import java.util.Scanner;

//Program to find out the Nth number in the fibonacci series
public class NthFibonacci {
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 0) {
            System.out.println("Invalid input! N must be a non-negative integer.");
        } else {
            System.out.println(fibo(n));
        }

		sc.close();
	}

	static int fibo(int n) {
		if(n==0||n==1)return n;
		int first = 0;
		int second = 1;
		int current = 0;
		for (int i = 2; i <= n; i++) {
			current = first + second;
			first = second;
			second = current;
		}
		return current;

	}
}

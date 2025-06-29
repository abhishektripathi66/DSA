public class SumOfNNaturalNumbers {

    public static void main(String[] args) {
        System.out.println(sumOfNNaturalNumbers(2,0));
    }

    public static int sumOfNNaturalNumbers(int n,int sum) {
        if (n == 0) return sum; // Base case: sum of first 0 natural numbers is 0
        return sumOfNNaturalNumbers(n - 1,sum+n); // Recursive case
    }
    
}

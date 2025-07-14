package codingquestions.arrayinterviewquestion;

//Find the missing number in an integer array of 1 to 10.
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int intArray[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        mn.missingNumber(intArray);
    }

    public void missingNumber(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != (i + 1)) {
                System.out.print("The missing number is " + (i + 1));
                return;
            }
        }
        System.out.println("all numbers are present");

    }

    public void missingNumberSolution2(int[] intArray) {
        int sum = 0;
        int total = 0;

        for (int i = 0; i < intArray.length; i++) {

            sum += intArray[i];
        }
        total = intArray.length * (intArray.length + 1) / 2;
        int difference = total - sum;
        System.out.println("Missing number is " + difference);

    }
}
    


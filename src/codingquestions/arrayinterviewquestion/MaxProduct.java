package codingquestions.arrayinterviewquestion;

/*
 * How to find maximum product of two integers in the array where all elements are positive.

Example

int[] intArray = {10,20,30,40,50};
maxProduct(intArray) // (40,50)
 */
public class MaxProduct {

    public static void main(String[] args) {
        maxproduct mp = new maxproduct();
        System.out.println(mp.maxProduct(new int[]{10, 20, 30, 40, 50}));
    }

    public String maxProduct(int[] intArray) {
        String out = "";
        int prod = 0;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if ((intArray[i] * intArray[j]) > prod) {
                    prod = intArray[i] * intArray[j];
                    out = +intArray[i] + "," + intArray[j];
                }
            }
        }
        return out;

    }
}

package codingquestions.recursion;

public class GenerateSubsets {

    public static void main(String[] args) {
        generateSubsets("ABC", "", 0);
    }

    public static void generateSubsets(String str, String curr, int index) {
        if (str.length() == index) {
            System.out.println(curr);
            return;
        }
        generateSubsets(str, curr, index + 1);
        generateSubsets(str, curr + str.charAt(index), index + 1);


    }

}

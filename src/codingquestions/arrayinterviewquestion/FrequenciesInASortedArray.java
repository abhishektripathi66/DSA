package codingquestions.arrayinterviewquestion;

public class FrequenciesInASortedArray {
    public static void main(String[] args) {
        frequncies(new int[]{10, 10, 10, 25, 30, 30});
    }

    public static void frequncies(int[] arr) {
        int a = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == a) count++;
            else {
                System.out.println(a + " " + count);
                a = arr[i];
                count = 1;
            }
        }
        System.out.println(a + " " + count);
    }
}
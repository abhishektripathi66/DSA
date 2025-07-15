package codingquestions.arrayinterviewquestion;

public class MaximumAppearingElement {
    // the left and right length is less than 100 and the size of index i is less than 10^5
    public static void main(String[] args) {
        int[] left = {1, 2, 5, 15};
        int[] right = {5, 8, 7, 18};
        System.out.println(findmax(left, right));
        int[] left1 = {1, 2, 4};
        int[] right1 = {4, 5, 7};
        System.out.println(findmaxusingprefixsumarray(left1, right1));
    }


    //time complexity O(n*m)
    public static int findmax(int[] left, int[] right) {
        int[] a = new int[100];
        int index = 0;
        for (int i = 0; i < left.length; i++) {
            for (int j = left[i]; j <= right[i]; j++) {
                a[j]++;
                if (a[j] > a[index]) {
                    index = j;
                }
            }
        }
        return index;
    }

    //time complexity O(n+m)
    public static int findmaxusingprefixsumarray(int[] left, int[] right) {
        int[] a = new int[101];
        for (int i = 0; i < left.length; i++) {
            a[left[i]]++;
            a[right[i] + 1]--;
        }
        int index = 0;
        for (int i = 1; i < 100; i++) {
            a[i] += a[i - 1];
            if (a[i] > a[index]) {
                index = i;
            }
        }

        return index;


    }


}

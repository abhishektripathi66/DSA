import java.util.Arrays;

public class MedianOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(MedianOfTwoArrays.findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length;
        int j = nums2.length;
        if ((i == 1 && j == 0)) {
            return nums1[0];
        } else if ((i == 0 && j == 1)) {
            return nums2[0];
        }
        // int max = Math.max(i,j);
        int sum = i + j;
        int[] finals = new int[sum];
        int l = 0;
        int m = 0;
        for (int k = 0; k < sum; k++) {
            if (l < i && l < j) {
                finals[k] = nums1[l];
                System.out.println(finals[k]);
                k++;
                finals[k] = nums2[m];
                System.out.println(finals[k]);
                System.out.println(l);
                System.out.println(m);
                l++;
                m++;
            } else if (m >= i && l < j) {
                finals[k] = nums2[l];
                System.out.println(l);
                System.out.println(nums2[l]);
                System.out.println(finals[k]);
                l++;
            } else if (m < i && l >= j) {
                finals[k] = nums1[m];
                System.out.println(m);
                System.out.println(nums1[m]);
                System.out.println(finals[k]);
                m++;
            }

        }
        int k = 1;
        System.out.println(finals[k]);
        System.out.println(finals[k - 1]);
        System.out.println(finals[k + 1]);
        Arrays.sort(finals);
        if (sum % 2 == 0) {
            int x = sum / 2;
            return ((double) (finals[x - 1] + finals[x]) / 2);
        } else {
            int x = sum / 2;
            System.out.println(x);
            System.out.println(finals[x]);
            System.out.println(finals[x - 1]);
            System.out.println(finals[x + 1]);
            return finals[x];
        }
    }
}

/**
 * 973. K Closest Points to Origin
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 **/

import java.util.Arrays;

/**
 * Mys soluion
 */
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        double[][] a = new double[points.length][2];
        int[][] out = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            a[i][0] = findDistance(points[i]);
            a[i][1] = i;
            System.out.println(a[i][0] + " , " + a[i][1]);
        }
        sortbyColumn(a);

        for (int i = 0; i < k; i++) {
            out[i] = points[(int) a[i][1]];
        }
        return out;

    }

    public void sortbyColumn(double arr[][]) {
        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));
    }

    public double findDistance(int[] a) {
        return Math.pow(Math.pow(a[0], 2) + Math.pow(a[1], 2), 0.5);
    }
}

/**
 * best solution
 */
class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        int smallestK = quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, smallestK);
    }

    private int quickSelect(int[][] points, int left, int right, int k) {
        if (left >= right) {
            return k;
        }
        int l = left, r = right;
        int pivotIdx = left + (right - left) / 2;
        int pivotDist = getDist(points[pivotIdx]);

        while (l <= r) {
            while (l <= r && getDist(points[l]) < pivotDist) {
                l++;
            }
            while (l <= r && getDist(points[r]) > pivotDist) {
                r--;
            }

            if (l <= r) {
                swap(points, l++, r--);
            }
        }

        if (k <= r) {
            return quickSelect(points, left, r, k);
        }

        return quickSelect(points, l, right, k);
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

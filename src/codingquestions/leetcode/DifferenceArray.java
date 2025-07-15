package codingquestions.leetcode;

import java.util.AbstractList;
import java.util.*;

public class DifferenceArray {

    public static void main(String[] args) {
        DifferenceArray da = new DifferenceArray();
        List<List<Integer>> la = da.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        for (List<Integer> a : la) {
            System.out.println(a);
        }
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        return new AbstractList<List<Integer>>() {
            List<Integer> first = null;
            List<Integer> second = null;

            @Override
            public List<Integer> get(int i) {
                if (first == null) {
                    process();
                }
                return (i == 0) ? first : second;
            }

            @Override
            public int size() {
                return 2;
            }

            private void process() {
                first = new ArrayList<>(); //initialising the array
                second = new ArrayList<>(); //initialising the array
                //using size as 2001 coz the values of array range from -1000 to 1000
                byte[] m1 = new byte[2001]; //initialising the byte array
                byte[] m2 = new byte[2001]; //initialising the byte array
                //marking all the numbers of array 2 in the byte
                for (int i : nums2) {
                    m1[i + 1000] = 0b1; // adding 1 for present value
                }
                //check in nums1 array if its present or not
                for (int i : nums1) {
                    int x = i + 1000;
                    if (m1[x] != 0b1) { // if value not present then add in first
                        m1[x] = 0b1;
                        first.add(i);
                    }
                    m2[x] = 0b1;
                }
                for (int i : nums2) {
                    int x = i + 1000;
                    if (m2[x] != 0b1) {
                        m2[x] = 0b1;
                        second.add(i);
                    }
                }

            }
        };
    }
}

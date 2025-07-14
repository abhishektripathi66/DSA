import java.util.Map;
import java.util.TreeMap;

/**
 * 1331. Rank Transform of an Array
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an array of integers arr, replace each element with its rank.
 * <p>
 * The rank represents how large the element is. The rank has the following rules:
 * <p>
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 **/
public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length, i = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (i = 0; i < n; i++) {
            map.put(arr[i], 1);
        }
        i = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), i);
            i++;
        }
        for (i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

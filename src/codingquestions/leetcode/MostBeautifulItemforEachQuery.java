import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2070. Most Beautiful Item for Each Query
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.
 * <p>
 * You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.
 * <p>
 * Return an array answer of the same length as queries where answer[j] is the answer to the jth query.
 **/
public class MostBeautifulItemforEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int currMaxBeauty = 0;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int[] item : items) {
            if (item[1] <= currMaxBeauty) {
                continue;
            }
            currMaxBeauty = item[1];
            m.put(item[0], currMaxBeauty);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> entry = m.floorEntry(queries[i]);
            if (entry != null) {
                res[i] = entry.getValue();
            }
        }
        return res;
    }
}

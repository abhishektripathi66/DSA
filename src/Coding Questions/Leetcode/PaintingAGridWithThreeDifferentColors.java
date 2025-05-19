/*
1931. Painting a Grid With Three Different Colors
Solved
Hard
Topics
Companies
Hint
You are given two integers m and n. Consider an m x n grid where each cell is initially white. You can paint each cell red, green, or blue. All cells must be painted.

Return the number of ways to color the grid with no two adjacent cells having the same color. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 1, n = 1
Output: 3
Explanation: The three possible colorings are shown in the image above.
Example 2:


Input: m = 1, n = 2
Output: 6
Explanation: The six possible colorings are shown in the image above.
Example 3:

Input: m = 5, n = 5
Output: 580986
 

Constraints:

1 <= m <= 5
1 <= n <= 1000
*/
//sol by editorial
class Solution {

    static final int mod = 1000000007;

    public int colorTheGrid(int m, int n) {
        // Hash mapping stores all valid coloration schemes for a single row that meet the requirements
        Map<Integer, List<Integer>> valid = new HashMap<>();
        // Enumerate masks that meet the requirements within the range [0, 3^m)
        int maskEnd = (int) Math.pow(3, m);
        for (int mask = 0; mask < maskEnd; ++mask) {
            List<Integer> color = new ArrayList<>();
            int mm = mask;
            for (int i = 0; i < m; ++i) {
                color.add(mm % 3);
                mm /= 3;
            }
            boolean check = true;
            for (int i = 0; i < m - 1; ++i) {
                if (color.get(i).equals(color.get(i + 1))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                valid.put(mask, color);
            }
        }

        // Preprocess all (mask1, mask2) binary tuples, satisfying mask1 and mask2 When adjacent rows, the colors of the two cells in the same column are different
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int mask1 : valid.keySet()) {
            for (int mask2 : valid.keySet()) {
                boolean check = true;
                for (int i = 0; i < m; ++i) {
                    if (
                        valid.get(mask1).get(i).equals(valid.get(mask2).get(i))
                    ) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    adjacent
                        .computeIfAbsent(mask1, k -> new ArrayList<>())
                        .add(mask2);
                }
            }
        }

        Map<Integer, Integer> f = new HashMap<>();
        for (int mask : valid.keySet()) {
            f.put(mask, 1);
        }
        for (int i = 1; i < n; ++i) {
            Map<Integer, Integer> g = new HashMap<>();
            for (int mask2 : valid.keySet()) {
                for (int mask1 : adjacent.getOrDefault(
                    mask2,
                    new ArrayList<>()
                )) {
                    g.put(
                        mask2,
                        (g.getOrDefault(mask2, 0) + f.getOrDefault(mask1, 0)) %
                        mod
                    );
                }
            }
            f = g;
        }

        int ans = 0;
        for (int num : f.values()) {
            ans = (ans + num) % mod;
        }
        return ans;
    }
}

/*
3531. Count Covered Buildings
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

A building is covered if there is at least one building in all four directions: left, right, above, and below.

Return the number of covered buildings.

 

Example 1:



Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]

Output: 1

Explanation:

Only building [2,2] is covered as it has at least one building:
above ([1,2])
below ([3,2])
left ([2,1])
right ([2,3])
Thus, the count of covered buildings is 1.
Example 2:



Input: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]

Output: 0

Explanation:

No building has at least one building in all four directions.
Example 3:



Input: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]

Output: 1

Explanation:

Only building [3,3] is covered as it has at least one building:
above ([1,3])
below ([5,3])
left ([3,2])
right ([3,5])
Thus, the count of covered buildings is 1.
 

Constraints:

2 <= n <= 105
1 <= buildings.length <= 105 
buildings[i] = [x, y]
1 <= x, y <= n
All coordinates of buildings are unique.
*/
class Solution {
    static class Pair<F, S> {
        public F first;
        public S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        n = buildings.length;
        List<Pair<Pair<Integer, Integer>, Integer>> bd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bd.add(new Pair<>(new Pair<>(buildings[i][0], buildings[i][1]), i));
        }
        bd.sort(Comparator.comparingInt((Pair<Pair<Integer, Integer>, Integer> p) -> p.first.first)
                .thenComparingInt(p -> p.first.second));
        Set<Integer> st = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            if (bd.get(i - 1).first.first.equals(bd.get(i + 1).first.first)) {
                st.add(bd.get(i).second);
            }
        }
        bd.sort((a, b) -> {
            if (a.first.second.equals(b.first.second)) {
                return a.first.first.compareTo(b.first.first);
            } else {
                return a.first.second.compareTo(b.first.second);
            }
        });
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (bd.get(i - 1).first.second.equals(bd.get(i + 1).first.second)) {
                if (st.contains(bd.get(i).second)) res++;
            }
        }
        return res;
    }
}

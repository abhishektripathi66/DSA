package datastructures.disjointset;

/*
 * Disjoint Set (Union-Find)
 *
 * A Disjoint Set is a data structure that keeps track of a set of elements
 * partitioned into multiple disjoint (non-overlapping) subsets.
 *
 * It supports two main operations:
 *  - find(x): Returns the representative (root) of the set containing x
 *  - union(x, y): Merges the sets containing x and y
 *
 * This implementation uses:
 *  - Path Compression (in find) to flatten the tree
 *  - Union by Rank to keep the tree balanced
 *
 * These optimizations make operations extremely efficient.
 *
 * Time Complexity:
 *  - find(x):    O(α(n)) amortized
 *  - union(x,y): O(α(n)) amortized
 *    where α(n) is the inverse Ackermann function (very slow-growing, ~constant)
 *
 * Auxiliary Space Complexity: O(n)
 *
 * Example:
 *    Initially: {0}, {1}, {2}, {3}, {4}
 *
 *    union(0,1) → {0,1}, {2}, {3}, {4}
 *    union(1,2) → {0,1,2}, {3}, {4}
 *    union(3,4) → {0,1,2}, {3,4}
 *
 *    find(2) → 0 (representative of the set)
 *    find(4) → 3
 */

public class DisjointSetAnother {

    int[] parent, rank;
    int n;

    DisjointSetAnother(int n){
        this.n = n;
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i; //each elements is in its own set
            rank[i] = 0; //initially 0
        }
    }


    public static void main(String[] args) {
        DisjointSetAnother ds = new DisjointSetAnother(5);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);

        System.out.println(ds.find(2)); // same as 0
        System.out.println(ds.find(4)); // same as 3

    }

    private int find(int x){
        if(x == parent[x])
            return x;
        //path compression
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    //union by rank
    private void union(int x, int y){

        int xRoot = find(x), yRoot = find(y);

        if(xRoot == yRoot) //both are in same set
            return;
        
        //assign smaller height node as a child of higher hight node
        if(rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot;
        }
        else if(rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }
        else{
            //rank will only increase, if both tree have same height
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    
}

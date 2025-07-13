public class disjointSet {

    // Array to store the parent set for each element
    protected int[] set;

    private int[] rank;   // Array to store the rank (approximate height of tree)

    // Constructor to initialize the disjoint set with `n` elements
    public disjointSet(int n) {
        set = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i; // Each element is initially its own parent (separate sets)
            rank[i] =0;
        }
    }

    // Constructor to initialize the disjoint set from an existing array
    public disjointSet(int[] set) {
        this.set = new int[set.length];
        for (int i = 0; i < set.length; i++) {
            this.set[i] = set[i];

        }
    }

    // Method to find the set that the element `x` belongs to
    public int find(int x) {
        if (set[x] != x) {
            set[x] = find(set[x]); // Recursively find the root and compress the path
        }
        return set[x];
    }

    // Method to check if two elements belong to the same set
    public boolean areInTheSameSet(int x, int y) {
        return (find(x) == find(y));
    }

    // Method to perform the union of two sets (merge two sets)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                set[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                set[rootX] = rootY;
            } else {
                set[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
    public static void main(String[] args) {
        disjointSet ds = new disjointSet(5);

        // Test unions
        ds.union(0, 2);
        ds.union(4, 2);
        System.out.println("0 and 4 in same set: " + ds.areInTheSameSet(0, 4));
        System.out.println("1 and 0 in same set: " + ds.areInTheSameSet(1, 0));

        // Test path compression
        disjointSet ds2 = new disjointSet(6);
        ds2.union(0, 1);
        ds2.union(1, 2);
        ds2.union(2, 3);
        System.out.println("Find(3): " + ds2.find(3));
        System.out.println("Find(0): " + ds2.find(0));
    }
}
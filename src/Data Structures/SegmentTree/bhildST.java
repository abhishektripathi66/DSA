// A Segment Tree is a special data structure used to answer range queries (like sum, minimum, maximum) and update elements in an array efficiently. It is much faster than checking every element in the range each time.

// Simple Explanation
// Imagine you have an array and you want to quickly find the sum (or min/max) of any part of it, and also update values.
// A segment tree breaks the array into segments (parts) and stores information about each segment in a tree structure.
// Each node in the tree represents a segment (range) of the array and stores the answer for that segment.
// The root node represents the whole array, its children represent halves, and so on, down to single elements (leaves).
// Example: Build a Segment Tree for Range Sum
// Suppose you have an array: [1, 3, 5, 7, 9, 11]

// Steps to Build
// Start with the whole array as the root.
// Divide the array into two halves, recursively, until each segment has one element.
// Store the sum of each segment at each node.



class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n]; // Enough space for the tree
        build(arr, 0, n - 1, 0);
    }

    // Build the segment tree
    private void build(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * node + 1);
        build(arr, mid + 1, end, 2 * node + 2);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Query sum in range [l, r]
    public int query(int l, int r) {
        return queryUtil(0, n - 1, l, r, 0);
    }

    private int queryUtil(int start, int end, int l, int r, int node) {
        if (r < start || end < l) return 0; // No overlap
        if (l <= start && end <= r) return tree[node]; // Total overlap
        int mid = (start + end) / 2;
        return queryUtil(start, mid, l, r, 2 * node + 1) +
               queryUtil(mid + 1, end, l, r, 2 * node + 2);
    }
    /**
    * Updates the value at a specific index in the original array 
    * and updates the segment tree accordingly.
     * @param ind The index to update (0-based)
     * @param val The new value to set at the given index
     */
    public void update(int ind , int val){
        updateUtil(0,n-1,0,ind,val);
    }
    /**
     * A utility to update segment tree recursively.
     * @param start  Start index of current segment tree
     * @param end  End index of current segment tree
     * @param node  Index of current node in the segement tree
     * @param ind  The index to update (0-based)
     * @param val  The new value to set at the given index
     */
    private void updateUtil(int start, int end ,int node ,int ind , int val){
        if(start==end){
            tree[node] = val;
        }
        else{
            int mid = start + (end - start) / 2; // To Avoid Overflow issues
            if(ind<=mid){
                updateUtil(start, mid, 2*node+1, ind, val);
            }
            else{
                updateUtil(mid+1, end, 2*node+2, ind, val);
            }
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
}
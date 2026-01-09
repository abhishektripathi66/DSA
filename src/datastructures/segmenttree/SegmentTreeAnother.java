package datastructures.segmenttree;

/*
 * Segment Tree for Range Query and Point Update
 *
 * A Segment Tree is a tree-based data structure used to efficiently answer
 * range queries (such as sum, minimum, maximum, gcd, etc.) on an array.
 * It also supports updating individual elements in logarithmic time.
 *
 * The tree is built recursively where:
 *  - Each leaf node represents a single array element
 *  - Each internal node represents a combination (e.g., sum) of a segment
 *
 * This implementation supports:
 *  - Range Sum Query
 *  - Point Update using difference propagation
 *
 * Time Complexity:
 *  - Build Tree: O(n)
 *  - Range Query: O(log n)
 *  - Point Update: O(log n)
 *
 * Auxiliary Space Complexity:
 *  - O(n) for the segment tree array (commonly allocated as 4*n for safety)
 *
 * Example:
 *   arr = [0, 1, 3, 5, -2, 3]
 *   Query sum(1, 3) → 9
 *   Update index 2 to value 5
 *   Query sum(1, 3) → 11
 */


//rough work comment
//useful for problems involving range queries, such as finding the sum, minimum, 
//maximum, or any other operation over a specific range of elements in an array
//it is built recursively, until each segment represents a one element
//fast query and update operations with a time complexity of O(log n)


/*

Visual example with array representation

0-based indexing:
Parent → i
Left child → 2i + 1
Right child → 2i + 2

if 1-based indexing is used:
Parent → i
Left child → 2i
Right child → 2i + 1

si = 0   // root of segment tree
tree[0]   → whole range (root)
├── tree[1] = 2*0 + 1 → left child
│   ├── tree[3] = 2*1 + 1
│   └── tree[4] = 2*1 + 2
└── tree[2] = 2*0 + 2 → right child
    ├── tree[5] = 2*2 + 1
    └── tree[6] = 2*2 + 2

For arr = {0, 1, 3, 5, -2, 3}
tree[0] = sum(0..5) //whole range
├── tree[1] = sum(0..2)
│   ├── tree[3] = sum(0..1)
│   │   ├── tree[7] = arr[0]
│   │   └── tree[8] = arr[1]
│   └── tree[4] = arr[2]
└── tree[2] = sum(3..5)
    ├── tree[5] = sum(3..4)
    └── tree[6] = arr[5]
*/

public class SegmentTreeAnother {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 3, 5, -2, 3 };
        int n = arr.length;      
        
        //A perfect binary tree with n leaf nodes has exactly 2n-1 total nodes
        //If n is not a power of two, the segment tree will not be a perfect binary tree and may require an extra level to accommodate all elements
        //for example, n=5 which needs a tree that can hold up to 8 leaves, rounding up to next power of 2
        //so next power of 2 can be obtained from range n to 2n, and taking maximum 2n for safety, we use total size of 4n for a segment tree.
        int[] tree = new int[4*n];

        constructST(arr, tree, 0, n - 1, 0);

        // Print segment tree
        // for (int i = 0; i < 4*n; i++) {
        //     System.out.print(tree[i] + " ");
        // }

        int qs = 1, qe = 3; //query
        int ss = 0, se = n - 1; //segment range in original array
        int si = 0; //index in segment tree
        
        //if invlaid query range is passed 
        if (qs < 0 || qe >= n || qs > qe) {
            throw new IllegalArgumentException("Invalid query range");
        }
        System.out.println("getSumRec(1, 3) : "+getSumRec(tree, qs, qe, ss, se, si));

        
        //change made at index i = 2
        int i = 2;
        int newVal = 5;
        int diff = newVal - arr[i]; // compute diff first
        arr[i] = newVal;
        updateRec(tree, ss, se, i, si, diff);
        System.out.println("After updating arr[2] to 5 from 3");
        System.out.println("getSumRec(1, 3) : "+getSumRec(tree, qs, qe, ss, se, si));

    }


    // ss = segment start
    // se = segment end
    // si = segment tree index
    private static int constructST(int[] arr, int[] tree, int ss, int se, int si) {

        // base case: leaf node
        if (ss == se) {
            tree[si] = arr[ss];
            return tree[si];
        }

        int mid = ss + (se - ss) / 2;

        //build left and right subtrees
        //left subtree result is stored at index 2*si + 1
        //right subtree result is stored at index 2*si + 2
        int leftSum = constructST(arr, tree, ss, mid, 2 * si + 1);
        int rightSum = constructST(arr, tree, mid + 1, se, 2 * si + 2);

        // store sum at current node
        tree[si] = leftSum + rightSum;

        return tree[si];
    }

    //qs = Query Start index
    //qe = Query End index
    //ss = Segment Start index (current node range)
    //se = Segment End index (current node range)
    //si = Segment Tree index
    //O(log n) average for all queries
    private static int getSumRec(int[] tree, int qs, int qe, int ss, int se, int si) {

        // total overlap
        if (qs <= ss && qe >= se) {
            return tree[si];
        }

        // no overlap
        if ( qs > se || qe < ss) {
            return 0;
        }

        // partial overlap
        int mid = ss + (se - ss) / 2;

        return getSumRec(tree, qs, qe, ss, mid, 2 * si + 1)
         + getSumRec(tree, qs, qe, mid + 1, se, 2 * si + 2);
    }

    //i = index in original array that was updated
    //diff = newValue − oldValue
    //O(log n) time complexity
    private static void updateRec(int[] tree, int ss, int se, int i, int si, int diff) {

        //index out of this segment
        if (i < ss || i > se) {
            return;
        }

        //update this node
        tree[si] += diff;

        //if not a leaf, propagate further
        if (ss != se) {
            int mid = ss + (se - ss) / 2;

            updateRec(tree, ss, mid, i, 2 * si + 1, diff);
            updateRec(tree, mid + 1, se, i, 2 * si + 2, diff);
        }
}


}

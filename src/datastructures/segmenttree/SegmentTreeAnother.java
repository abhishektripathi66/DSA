package datastructures.segmenttree;

//useful for problems involving range queries, such as finding the sum, minimum, maximum, or any other operation over a specific range of elements in an array
//it is built recursively, until each segment represents a one element
//fast query and update operations with a time complexity of O(log n)


//Visual example with array representation

/* 
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
        for (int i = 0; i < 2 * n; i++) {
            System.out.print(tree[i] + " ");
        }
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
        //right subtree result is stored at index 2*si + 1
        int leftSum = constructST(arr, tree, ss, mid, 2 * si + 1);
        int rightSum = constructST(arr, tree, mid + 1, se, 2 * si + 2);

        // store sum at current node
        tree[si] = leftSum + rightSum;

        return tree[si];
    }

}

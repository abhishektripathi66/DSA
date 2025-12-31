package datastructures.segmenttree;

//useful for problems involving range queries, such as finding the sum, minimum, maximum, or any other operation over a specific range of elements in an array
//it is built recursively, until each segment represents a one element
//fast query and update operations with a time complexity of O(log n)
public class SegmentTreeAnother {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 3, 5, -2, 3 };
        int n = arr.length;        
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

        // build left and right subtrees
        int leftSum = constructST(arr, tree, ss, mid, 2 * si + 1);
        int rightSum = constructST(arr, tree, mid + 1, se, 2 * si + 2);

        // store sum at current node
        tree[si] = leftSum + rightSum;

        return tree[si];
    }

}

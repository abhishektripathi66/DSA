package algorithms.greedyalgorithms;

import java.util.PriorityQueue;

/**
 * Huffman Coding algorithm is a greedy approach for data compression.
 * 
 * It builds a prefix binary tree where the most frequent characters have the shortest binary codes.
 * so that the total encoded length of all characters is minimized.
 * 
 * Binary tree is constructed based on characters and their frequency given. In which
 * - Every input character is a leaf node and other interal nodes are represented as '$'.
 * - Every left child edge is labelled as '0' and right edge as '1'.
 * - Every root to leaf path represents Huffman code of the leaf. 
 * 
 * Time Complexity: O(n log n)
 * Auxiliary Space Complexity: O(n)
 * 
 * Example:
 *   Input:
 *     Characters = ['a', 'd', 'b', 'e', 'f']
 *     Frequencies = [10, 50, 20, 40, 80]
 *   Output (one possible set of Huffman Codes):
 *     f 0
 *     d 10
 *     a 1100
 *     b 1101
 *     e 111
 *
 * Note: Huffman codes are not unique; different valid trees may give different bit patterns.
 */

public class HuffmanCoding {
    
    public static void main(String[] args){
        // input characters and their corresponding frequencies
        char[] arr = {'a', 'd', 'b', 'e', 'f'};
        int[] freq = {10, 50, 20, 40, 80};

        //generate and print Huffman codes
        printHCodes(arr, freq);
    }

    private static void printHCodes(char[] arr, int[] freq){
        PriorityQueue<Node> h = new PriorityQueue<>((n1, n2) -> n1.freq  - n2.freq); //min-heap

        //O(nlogn)
        for(int i=0; i<arr.length; i++)
            h.add(new Node(arr[i], freq[i], null, null));
        
        //O(nlogn)
        //using min-heap because constructing tree from the bottom
        //then in pq (min-heap), it will be just one root node and its frequency will be total sum of all frequencies 
        //most frequent ones will be closer to the root, hence shorter binary codes
        while(h.size() > 1){
            Node l = h.poll();
            Node r = h.poll();
            //adding internal node with combined frequency, character '$ is used as its char
            h.add(new Node('$', l.freq + r.freq, l, r));
        }

        //traversal from constructed root
        printRec(h.peek(), "");
        
    }
    private static void printRec(Node root, String s){
        if(root.ch != '$'){
            // Leaf node: print the character and its Huffman code
            System.out.println(root.ch+" "+s);
            return;
        }
        //recurse left with '0' and right with '1'
        printRec(root.left, s+"0");
        printRec(root.right, s+"1");
    }
}

class Node{
    char ch;
    int freq;
    Node left;
    Node right;

    Node(char c, int f, Node l, Node r){
        this.ch = c;
        this.freq = f;
        left = l;
        right = r;
    }
}
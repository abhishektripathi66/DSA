package GreedyAlgorithms;

import java.util.PriorityQueue;

public class HuffmanCoding {
    
    public static void main(String[] args){
        char[] arr = {'a', 'd', 'b', 'e', 'f'};
        int[] freq = {10, 50, 20, 40, 80};

        printHCodes(arr, freq);
    }

    private static void printHCodes(char[] arr, int[] freq){
        PriorityQueue<Node> h = new PriorityQueue<>((n1, n2) -> n1.freq  - n2.freq); //min-heap

        //O(nlogn)
        for(int i=0; i<arr.length; i++)
            h.add(new Node(arr[i], freq[i], null, null));
        
        //O(nlogn)
        while(h.size() > 1){
            Node l = h.poll();
            Node r = h.poll();
            h.add(new Node('$', l.freq + r.freq, l, r));
        }

        printRec(h.peek(), "");
        
    }
    private static void printRec(Node root, String s){
        if(root.ch != '$'){
            System.out.println(root.ch+" "+s);
            return;
        }
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
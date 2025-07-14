package codingquestions.leetcode.ds;

public class Node {

    public String key;
    public int count;
    public Node next;
    public Node prev;

    public Node(String s, int n) {
        count = n;
        key = s;
        next = null;
        prev = null;
    }

}

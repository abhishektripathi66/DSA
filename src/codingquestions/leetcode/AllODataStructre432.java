package codingquestions.leetcode;

import java.util.HashMap;

import codingquestions.leetcode.ds.Node;

/**
 * 432. All O`one Data Structure
 * Solved
 * Hard
 * Topics
 * Companies
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
 * <p>
 * Implement the AllODataStructre432 class:
 * <p>
 * AllODataStructre432() Initializes the object of the data structure.
 * inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
 * dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 * getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 * getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 * Note that each function must run in O(1) average time complexity.
 **/


public class AllODataStructre432 {
    Node head;
    Node tail;
    private HashMap<String, Node> nodes = new HashMap<>();

    public AllODataStructre432() {
        head = new Node("", -1);
        tail = new Node("", Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    //b is directly after a
    private void swap(Node a, Node b) {
        Node t = b.next;
        a.next = t;
        t.prev = a;
        b.next = a;
        t = a.prev;
        t.next = b;
        a.prev = b;
        b.prev = t;
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void updateInc(Node n) {
        while (n.next != tail && n.count > n.next.count) {
            swap(n, n.next);
        }
    }

    private void updateDec(Node n) {
        while (n.prev != head && n.count < n.prev.count) {
            swap(n.prev, n);
        }
    }

    public void inc(String key) {
        Node n = nodes.getOrDefault(key, new Node(key, 0));
        int c = ++n.count;
        //if not new key
        if (c != 1) {
            if (c > tail.prev.count) {
                delete(n);
                n.next = tail;
                n.prev = tail.prev;
                tail.prev.next = n;
                tail.prev = n;
            } else {
                updateInc(n);
            }
        } else { //new key
            nodes.put(key, n);
            n.prev = head;
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
        }
    }

    public void dec(String key) {
        Node n = nodes.get(key);
        if (--n.count == 0) {
            nodes.remove(key);
            delete(n);
        } else {
            updateDec(n);
        }
    }

    public String getMaxKey() {
        return head.next == tail ? "" : tail.prev.key;
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.key;
    }
}

/**
 * Your AllODataStructre432 object will be instantiated and called as such:
 * AllODataStructre432 obj = new AllODataStructre432();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

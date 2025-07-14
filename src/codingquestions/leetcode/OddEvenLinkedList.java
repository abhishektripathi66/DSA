package codingquestions.leetcode;

/**
 * 328. Odd Even Linked List
 * Solved
 * Medium
 * Topics
 * Companies
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 **/

import DS.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;  // Handle edge cases

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;  // To reconnect odd and even lists at the end

        while (even != null && even.next != null) {
            odd.next = even.next;  // Link current odd node to next odd node
            odd = odd.next;        // Move odd pointer
            even.next = odd.next;  // Link current even node to next even node
            even = even.next;      // Move even pointer
        }

        odd.next = evenHead;  // Append even list after odd list
        return head;
    }
}

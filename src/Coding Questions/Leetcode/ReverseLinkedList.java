/**
206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
  **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;  // Handle edge cases
        ListNode prev = null;
        ListNode next = head.next;
        ListNode curr = head;
        while(next!=null){
            curr.next=prev;
            prev = curr;
            curr= next;
            next=curr.next;
            curr.next=prev;

        }
        return curr;
    }
}

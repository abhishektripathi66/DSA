package codingquestions.leetcode;

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
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while(temp != null) {
            n++;
            temp = temp.next;
        }

        int mid = n/2;

        ListNode temp1 = head;
        for(int i=0; i<mid; i++) {
            temp1 = temp1.next;
        }

        return temp1;
    }
}
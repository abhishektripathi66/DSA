/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Runtime: 4 ms, faster than 37.54% of Java online submissions for Add Two Numbers.
Memory Usage: 48.3 MB, less than 21.62% of Java online submissions for Add Two Numbers.
 * 
 */

import DS.ListNode;

public class AddtwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode firstNode = null;
        ListNode n = l1;
        ListNode m = l2;
        int carry = 0;
        while (n != null && m != null) {
            int sum = n.val + m.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            if (l3 == null) {
                l3 = new ListNode(sum, null);
                firstNode = l3;
            } else {
                l3.next = new ListNode(sum, null);
                l3 = l3.next;

            }
            n = n.next;
            m = m.next;
        }

        while (m != null) {
            int sum = m.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            if (l3 == null) {
                l3 = new ListNode(sum, null);
                firstNode = l3;
            } else {
                l3.next = new ListNode(sum, null);
                l3 = l3.next;

            }
            m = m.next;
        }

        while (n != null) {
            int sum = n.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }
            if (l3 == null) {
                l3 = new ListNode(sum, null);
                firstNode = l3;
            } else {
                l3.next = new ListNode(sum, null);
                l3 = l3.next;

            }
            n = n.next;
        }

        if (carry != 0) {
            if (l3 == null) {
                l3 = new ListNode(carry, null);
                firstNode = l3;
            } else {
                l3.next = new ListNode(carry, null);
                l3 = l3.next;

            }
        }

        return firstNode;

    }

}

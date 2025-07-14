package codingquestions.leetcode;

import DS.ListNode;

public class RemoveDuplicatesLinkedList {

    public static void main(String[] args) {
        new RemoveDuplicatesLinkedList();

    }

    public ListNode deleteDuplicates(ListNode head) {

        // getting the head to a variable
        ListNode test = head;
        // having the head after getting first element with its next element
        ListNode sent = null;
        while (test != null) {
            //if there is no next element then that is the last element
            if (test.next != null) {
                //keep on checking if the current value is equal to the next element then remove the next element and keep repeating the process
                while (test.next != null && test.val == test.next.val) {
                    test.next = test.next.next;

                }
            }
            //Assign only the head to the sent and not any other mid value
            if (sent == null) {
                sent = test;
            }
            test = test.next;
        }
        return sent;
    }
}

package codingquestions.leetcode;

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if(count < k) return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        int i = 0;
        while(current != null && i < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        head.next = reverseKGroup(current, k);

        return prev;
    }
}
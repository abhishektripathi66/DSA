package codingquestions.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            temp = temp.next;
            n++;
        }

        int m = k%n;
        for(int i=0; i<m; i++) {
            while(curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }

        return head;
    }
}
package codingquestions.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class SwappingNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int n = 0;
        ListNode temp = head;
        int val1 = 0;
        int val2 = 0;

        while(temp!=null) {
            n++;
            if(n==k) {
                val1 = temp.val;
            }
            temp = temp.next;
        }

        int m = n-k+1;
        temp = head;
        int a = 0;
        
        while(temp != null) {            
            a++;
            if(a==m) {
                val2 = temp.val;
                temp.val = val1;
            }  
            temp = temp.next;

        }

        temp = head;
        n = 0;
        while(temp != null) {
            n++;
            if(n==k) {
                temp.val = val2;
            }
            temp = temp.next;
        }

        return head;
    }
}

/**
Runtime: 1 ms, faster than 72.47% of Java online submissions for Remove Nth Node From End of List.
Memory Usage: 42.7 MB, less than 16.51% of Java online submissions for Remove Nth Node From End of List.

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

**/
public class RemoveNthNodeFromLinkedList {
    
    public static void main(String[] args) {
        
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0;
        ListNode l = head;
        //this loop is used to get the total length of linkedList
        while(l!=null){
            l = l.next;
            i++;
        }
        // The order of element to be removed from 1st element
        int k=i-n;
        //The first element is to be removed and there is only one element
        if(k==0 && i==0) { return new ListNode();}
        //if 1st element is to be removed and there are many elements
        else if(k==0){
            return head.next;
        }
        i=0;
        ListNode m = head;
        l=head;
        //traverse from 1st till i-n elements
        while(i!=k){
            m=l;
            l=l.next;
            i++;
        }
        
        m.next = l.next;
        l.next = null;
        return head;
        
    }
}

// Questions frequently asked in interview from the platform Leetcode with their link and question tag.
// It's recommended to try solving them yourself before looking at the solution.

package codingquestions.linkedlist;

public class leetcode {
    private Node head;
    private Node tail;
    private Node next;
    private int size;

    public class Node{
        private int value;
        private Node next;

        private Node(int value){
            this.value = value;
        }

        private Node(int val, Node next){
            this.value = val;
            this.next = next;
        }
    }
    
    // Q1) Leetcode 83. Remove Duplicates from Sorted List
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public Node deleteDuplicates(Node head) {
        if(head == null){
            return head;
        }

        Node temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    // Q2) Leetcode 21. Merge Two Sorted Lists
    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    public Node mergeTwoLists(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node current = dummy;

        while(list1 != null && list2 != null){
            if(list1.value < list2.value){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null){
            current.next = list1;
        }else{
            current.next = list2;
        }
        return dummy.next;
    }

    // Q3) Leetcode 141. Linked list Cycle
    // https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // Q4) Follow-up for above: find the length of the cycle.
    public int LengthOfCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                Node temp = slow;
                int length = 0;

                do { 
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }
        return 0;
    }

    // Q5) Leetcode 142. Linked list Cycle II
    // https://leetcode.com/problems/linked-list-cycle-ii/description/
    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                length = LengthOfCycle(slow);
                break;
            }
        }

        if(length == 0){
            return null;
        }

        Node p1 = head;
        Node p2 = head;

        while(length > 0){
            p2 = p2.next;
            length--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // Q6) Leetcode 202. Happy Numbers (Asked in Google)
    // https://leetcode.com/problems/happy-number/description/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do { 
            slow = square(slow);
            fast = square(square(fast)); 
        } while (slow != fast);

        if (slow == 1){
            return true;
        }
        return false;
    }

    private int square(int number){
        int ans = 0;
        while(number > 0){
            int rem = number%10;
            ans += rem*rem;
            number = number/10;
        }
        return ans;
    }

    // Q7) Leetcode 876. Middle of the linked list
    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    public Node middleNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Q8) Leetcode 206. Reverse the Linked List (recursively)
    // https://leetcode.com/problems/reverse-linked-list/description/
    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Q9) Leetcode 206. in-place reversal of linked list (iterative)
    public Node reverseList(Node head) {
        if(head == null){
            return head;
        }

        Node pres = head;
        Node prev = null;
        Node next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    // 10) Leetcode 92. Reverse Linked List II
    // https://leetcode.com/problems/reverse-linked-list-ii/description/
    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }

        // skip the n-1 nodes
        Node current = head;
        Node prev = null;

        for(int i=0; current != null && i<left-1; i++){
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;
        Node next = current.next;
         
        // Reverse the list
        for(int i=0; current != null && i<(right-left)+1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}

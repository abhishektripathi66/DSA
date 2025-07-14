//Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

//solution code 

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

class DLL_question {
    // Function to reverse a doubly linked list
    public DLLNode reverseDLL(DLLNode head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        DLLNode curr = head;
        DLLNode temp = null;

        // Traverse the list and swap the next and prev pointers
        while (curr != null) {
            // Swap the next and prev pointers
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // Move to the next node (which is prev now due to the swap)
            curr = curr.prev;
        }

        // After the loop, temp will be pointing to the new head of the reversed list
        if (temp != null) {
            head = temp.prev; // Set the new head
        }

        return head; // Return the new head of the reversed list
    }
}

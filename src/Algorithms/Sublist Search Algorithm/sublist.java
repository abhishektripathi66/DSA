class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SublistSearch {

    // Function to check if A is a sublist of B
    static boolean isSublist(Node A, Node B) {
        if (A == null) return true; // Empty A is always a sublist
        if (B == null) return false; // Non-empty A can't match empty B

        Node currentB = B;

        while (currentB != null) {
            Node tempA = A;
            Node tempB = currentB;

            // Compare nodes of A with current part of B
            while (tempA != null && tempB != null && tempA.data == tempB.data) {
                tempA = tempA.next;
                tempB = tempB.next;
            }

            // If we completely traversed A, we found a match
            if (tempA == null) return true;

            // Move B's pointer one step forward
            currentB = currentB.next;
        }

        return false;
    }

    // Helper function to create a linked list from an array
    static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Function to print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {4, 1, 2, 3, 5};

        Node listA = createLinkedList(A);
        Node listB = createLinkedList(B);

        System.out.print("List A: ");
        printList(listA);
        System.out.print("List B: ");
        printList(listB);

        boolean result = isSublist(listA, listB);

        System.out.println("Is A a sublist of B? " + (result ? "Yes" : "No"));
    }
}

// Node class representing each element of the doubly linked list
class Node {
    int data;
    Node prev, next;

    // Constructor to create a new node with a given data
    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

// DoublyLinkedList class for basic operations
public class DoublyLinkedList {
    Node head;

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        head = null;
    }

    // Insert a new node at the end of the doubly linked list
    public void insert(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the end of the list
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Update the next and prev pointers to insert the new node
        last.next = newNode;
        newNode.prev = last;
    }

    // Delete a node with the given data from the doubly linked list
    public void delete(int data) {
        if (head == null) return; // List is empty, nothing to delete

        Node current = head;

        // Traverse the list to find the node to be deleted
        while (current != null && current.data != data) {
            current = current.next;
        }

        // Node not found
        if (current == null) return;

        // If the node to be deleted is the head
        if (current == head) {
            head = current.next;
        }

        // Update pointers to remove the node
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // Traverse the list from the head to the end
    public void traverseForward() {
        Node current = head;
        System.out.print("Doubly Linked List (forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Traverse the list from the end to the head (reverse)
    public void traverseBackward() {
        if (head == null) return; // Empty list

        // Traverse to the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // Traverse backward using the prev pointers
        System.out.print("Doubly Linked List (backward): ");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();
    }

    // Search for a node with the given data
    public boolean search(int data) {
        Node current = head;

        // Traverse the list to find the data
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }

        return false;
    }

    // Driver method for testing the doubly linked list implementation
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Inserting nodes into the doubly linked list
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);
        dll.insert(50);

        // Traversing forward
        System.out.println("Traversing forward:");
        dll.traverseForward(); // Expected output: 10 20 30 40 50

        // Traversing backward
        System.out.println("\nTraversing backward:");
        dll.traverseBackward(); // Expected output: 50 40 30 20 10

        // Deleting a node
        System.out.println("\nDeleting node 30:");
        dll.delete(30);
        dll.traverseForward(); // Expected output (without 30): 10 20 40 50

        // Searching for elements
        System.out.println("\nSearching for 40: " + dll.search(40)); // Output: true
        System.out.println("Searching for 60: " + dll.search(60)); // Output: false
    }
}

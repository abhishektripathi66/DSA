package datastructures.singlylinkedlist;

public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSinglyLinkedList(int Nodevalue) {
        Node node = new Node();
        node.value = Nodevalue;
        node.next = node;

        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void inserinLinkedlist(int nodevalue, int location) {
        Node node = new Node();
        node.value = nodevalue;
        if (head == null) {

            createCircularSinglyLinkedList(nodevalue);
            return;
        } else {
            if (location == 0) {
                node.next = head;
                head = node;
                tail.next = head;
            } else if (location >= size) {
                node.next = head;
                tail.next = node;
                tail = node;
            } else {
                Node tempNode = head;
                int index = 0;
                while (index < location - 1) {
                    tempNode = tempNode.next;
                    index++;
                }
                Node nextnode = tempNode.next;
                tempNode.next = node;
                node.next = nextnode;

            }
        }
        size++;
    }

    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("There is no linked list present");
            return;
        }
        Node test = head;
        System.out.println("The elements are :");
        System.out.println();
        while (test.next != head) {
            System.out.print(test.value);
            test = test.next;
            System.out.print("-->");

        }
        System.out.println(test.value);
        System.out.println();
        System.out.println("All the elemenets are printed");
        System.out.println();
    }

    public boolean findNodeInLinkedList(int nodevalue) {
        if (head == null) {
            System.out.println("There is no linked list present");
            return false;
        }
        Node test = head;
        while (test.next != head) {
            if (test.value == nodevalue) return true;
            test = test.next;

        }
        if (test.value == nodevalue) return true;
        return false;
    }
}

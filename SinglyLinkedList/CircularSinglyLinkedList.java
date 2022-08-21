package SinglyLinkedList;

public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSinglyLinkedList(int Nodevalue){
        Node node = new Node();
        node.value = Nodevalue;
        node.next =node;
        
        head = node;
        tail = node;
        size =1;
        return head;
     }
}

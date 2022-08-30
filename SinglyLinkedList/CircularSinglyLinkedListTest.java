package SinglyLinkedList;

public class CircularSinglyLinkedListTest {
    
    public static void main(String[] args) {
        var csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList(9);
        System.out.println("First value "+csll.head.value + " Second value " +csll.head.next.value);
        csll.traverseLinkedList();
        csll.inserinLinkedlist(10,0);
        csll.traverseLinkedList();
        csll.inserinLinkedlist(11,2);
        csll.traverseLinkedList();
        csll.inserinLinkedlist(12,2);
        csll.traverseLinkedList();
        csll.inserinLinkedlist(13,1);
        System.out.println("First value "+csll.head.value + " last value " +csll.tail.value);
        csll.traverseLinkedList();
    }
}

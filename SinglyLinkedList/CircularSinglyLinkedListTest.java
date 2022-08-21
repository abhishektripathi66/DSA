package SinglyLinkedList;

public class CircularSinglyLinkedListTest {
    
    public static void main(String[] args) {
        var csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList(10);
        System.out.println("First value "+csll.head.value + " Second value " +csll.head.next.value);
    }
}

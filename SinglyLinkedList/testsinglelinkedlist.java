package SinglyLinkedList;

public class testsinglelinkedlist {
    
    public static void main(String[] args) {
        SinglyLinkedList s = new SinglyLinkedList();
        s.createSinglyLinkedList(5);
        System.out.println(s.head.value);
        s.inserinLinkedlist(6, 0);
        System.out.println(s.head.value);
        s.inserinLinkedlist(7, 3);
        System.out.println(s.tail.value);
        s.inserinLinkedlist(8, 2);
        System.out.println(s.head.next.next.value);
    }
}

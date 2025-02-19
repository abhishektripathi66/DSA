class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SublistSearchAlgorithm { 
    
    public static boolean isSublist(Node list1, Node list2) {
        if (list2 == null) {
            return true; 
        }
        if (list1 == null) {
            return false; 
        }

        Node current1 = list1;
        Node current2 = list2;

        while (current1 != null) {
            Node temp1 = current1;
            Node temp2 = current2;

            
            while (temp2 != null) {
                if (temp1 == null || temp1.data != temp2.data) {
                    break; 
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            if (temp2 == null) {
                return true; 
            }

            current1 = current1.next;
        }

        return false; 
    }

    public static Node createLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null; 
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head; 
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4};

        Node list1 = createLinkedList(arr1);
        Node list2 = createLinkedList(arr2);

        boolean result = isSublist(list1, list2);
        System.out.println("Is list2 a sublist of list1? " + result); 
    }
}

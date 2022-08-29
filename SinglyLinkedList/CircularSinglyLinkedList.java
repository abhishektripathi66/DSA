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

     public void inserinLinkedlist(int nodevalue,int location){
        Node node = new Node();
        node.value = nodevalue;
        if(head==null){
            
            createCircularSinglyLinkedList(nodevalue);
            return;
        }
        else{
            if(location == 0){
                node.next = head;
                head = node;
                tail.next = head;
            }
            else if(location>=size){
                node.next=head;
                tail.next = node;
                tail = node;
            }
            else{
                Node tempNode = head;
                int index=0;
                while(index<location-1){
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
}

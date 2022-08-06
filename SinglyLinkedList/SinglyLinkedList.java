package SinglyLinkedList;

import org.w3c.dom.NodeList;

public class SinglyLinkedList{
 public Node head;
 public Node tail;
 public int size;

 public Node createSinglyLinkedList(int Nodevalue){
    Node node = new Node();
    node.next =null;
    node.value = Nodevalue;
    head = node;
    tail = node;
    size =1;
    return head;
 }

 //insert method 
 public void inserinLinkedlist(int nodevalue,int location){
    Node node = new Node();
    node.value = nodevalue;
    if(head==null){
        createSinglyLinkedList(nodevalue);
        return;
    }
    else{
        if(location == 0){
            node.next = head;
            head = node;
        }
        else if(location>=size){
            node.next=null;
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
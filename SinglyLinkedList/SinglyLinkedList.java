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

 public void traverseLinkedList(Node head){
        if(head==null){
            System.out.println("The head is null and there is no Linked List linked to it");
            return;
        }
        
            Node test = head;
            while(test!=null){
                System.out.print(test.value);
                if(test.next!=null)
                System.out.print("-->");
                test=test.next;
            }
        System.out.println();
 }

 public boolean searchValueInLinkedList(int nodeValue){
    if(head==null){
        System.out.println("The Linked List is empty");
        return false;
    }
            Node test = head; int i=0;
            while(test!=null){
                
                if(test.value==nodeValue){
                System.out.print(nodeValue+" is present at location "+i);
                return true;
                }
                test=test.next;
                i++;
            }
            System.out.println(nodeValue+" is not present in the linked list");
            return false;
 }

 public void deleteNode(int location){
    if(head==null){
        System.out.println("The Linked List is empty");
        return ;
    }
    else if(location>size){
        System.out.println("The number of nodes in the linked list is "+size);
        return ;
    }
    else if(location == 1){
        if(size == 1){
            head = null; tail = null;
        }
        else{
            head = head.next;
        }
    }
    else if(location==size){
        if(size == 1){
            head = null; tail = null;
        }
        else{
            Node test = head; 
            while(test!=null){
                
                if(test.next==tail){
                test.next=null;
                tail=test;
                return;
                }
                test=test.next;
                
            }
        }
    }
    else{

        Node test = head; int i=1;
            while(test!=null){
                
                if(i==(location-1)){
                Node ahead = test.next;
                test.next=test.next.next;
                ahead.next=null;
                return;
                }
                test=test.next;
                i++;
                
            }

    }
 }

 public void deleteSingleLinkedList(){
    if(head==null) System.out.println("the single linked list is already empty");
    else {
        head=null;tail=null;
        System.out.println("Single linked list is deleted");
    }
    return;
 }
}
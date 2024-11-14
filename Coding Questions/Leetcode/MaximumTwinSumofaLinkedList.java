/**
2130. Maximum Twin Sum of a Linked List
Solved
Medium
Topics
Companies
Hint
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
  **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


import java.util.*;

 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

/** My Solution **/
public class MaximumTwinSumofaLinkedList {
    public int pairSum(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
    int i=0;
    int sum=0;
    int j=a.size()-1;
        while(i<j){
            sum=Math.max(sum,a.get(i)+a.get(j));
            i++;j--;
        }
        return sum;
    }
}

/** best solution **/
class Solution1 {
    private static int [] a = new int[100000];
    public int pairSum(ListNode head) {

        //  APPROACH 1 :  

    //     ListNode fast =head;
    //     ListNode slow=head;
    //     while(fast.next!=null && fast.next.next!=null){
    //         fast=fast.next.next;
    //         slow=slow.next;
    //     }
    //     ListNode temp=reverse(slow.next);
    //     slow.next=temp;
    //     ListNode p1=head;
    //     ListNode p2=slow.next;
    //     System.out.print(p1.val+" "+p2.val);
    //     int maxSum=Integer.MIN_VALUE;
    //     while(p2!=null){
    //         maxSum=Math.max(maxSum,p1.val+p2.val);
    //         p1=p1.next;
    //         p2=p2.next;
    //     }
    //     return maxSum;
    // }

    // public static ListNode reverse(ListNode head){
    //     ListNode curr=head;
    //     ListNode prev=null;
    //     ListNode agla=null;
    //     while(curr!=null){
    //         agla=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=agla;
    //     }
    //     return prev;

            //  APPROACH 2 :
        
        final int[] arr = a;
        int size = 0;
        while(head != null){
            arr[size++] = head.val;
            head = head.next;
        }


        int m  =size/2;
        int maxSum = 0;
        for(int i=0;i<m;i++){
            --size;
            if(arr[i] + arr[size] > maxSum){
                maxSum = arr[i] + arr[size];
            }
        }
        return maxSum;

    }
}

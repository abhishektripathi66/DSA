import DS.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Runtime: 1 ms, faster than 80.07% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 42.8 MB, less than 72.98% of Java online submissions for Merge Two Sorted Lists.
 * 
 */
public class MergeTwoSortedList {
    
    public static void main(String[] args) {
        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l = null;
        ListNode l1 = null;
        while(list1!=null && list2!=null){
            if(list1.val==list2.val){
                if(l==null){
                    l = new ListNode(list1.val,new ListNode(list2.val,null));
                }
                else{
                    l.next = new ListNode(list1.val,new ListNode(list2.val,null));
                    l=l.next;
                    
                }
                
                list1 = list1.next; list2=list2.next;
                if(l1==null) l1=l;
                l=l.next;
                
            }
            else if(list1.val>list2.val){
                 if(l==null){
                    l = new ListNode(list2.val,null);
                }
                else{
                    l.next = new ListNode(list2.val,null);
                    l=l.next;
                }
                
                list2=list2.next;
                if(l1==null) l1=l;
                
            }
            else if(list1.val<list2.val){
                if(l==null){
                    l = new ListNode(list1.val,null);
                }
                else{
                    l.next = new ListNode(list1.val,null);
                    l=l.next;
                }
                list1=list1.next;
                if(l1==null) l1=l;
                
            }
        }
        while(list1!=null){
            
                if(l==null){
                    l = new ListNode(list1.val,null);
                }
                else{
                    l.next = new ListNode(list1.val,null);
                    l=l.next;
                }
                
                list1 = list1.next;
                if(l1==null) l1=l;
                
            }
            
        
        while(list2!=null){
                if(l==null){
                    l = new ListNode(list2.val,null);
                }
                else{
                    l.next = new ListNode(list2.val,null);
                    l=l.next;
                }
                list2=list2.next;
                if(l1==null) l1=l;
                
            }
        
        return l1;
    }
}


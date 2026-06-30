public class DL {
   Node head;       // head of doubly linked list
   private Node tail;  // tail for efficient insert at end
   private int size = 0;

   // Bucket Sort implementation using Doubly Linked List
   public int[] bucketSort(int[] arr){

       // Step 1: Find max and min values
       int max = arr[0];
       int min = arr[0];

       for (int i = 1; i < arr.length; i++) {
           if (max < arr[i]) max = arr[i];
           if (min > arr[i]) min = arr[i];
       }

       // Step 2: Decide number of buckets (√n is common choice)
       int no_of_buckets = (int) Math.ceil(Math.sqrt(arr.length));

       // Step 3: Calculate range of each bucket
       int range = (int) Math.ceil((double)(max - min + 1) / no_of_buckets);

       // Step 4: Create buckets (array of linked lists)
       DL[] buckets = new DL[no_of_buckets];

       for (int i = 0; i < buckets.length; i++) {
           buckets[i] = new DL();  // initialize each bucket
       }

       // Step 5: Distribute elements into buckets
       for (int i = 0; i < arr.length; i++) {
           int bucketIndex = (arr[i] - min) / range; // find correct bucket
           buckets[bucketIndex].insertLast(arr[i]); // insert into DLL
       }

       // Step 6: Sort each bucket individually
       for (int i = 0; i < buckets.length; i++) {
           buckets[i].head = selectionSort(buckets[i].head);
       }

       // Step 7: Merge all buckets back into array
       int j = 0;
       for (DL bucket : buckets) {
           Node list = bucket.head;
           while (list != null) {
               arr[j++] = list.value;
               list = list.next;
           }
       }

       return arr;
   }

   // Insert at beginning of DLL
   public void insertFirst(int val){
        Node node = new Node(val);

        if(head == null){
            // If list is empty, head and tail both point to node
            head = node;
            tail = head;
        } else {
            // Insert before current head
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
   }

   // Insert at end (used for buckets)
   public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);

        node.prev = tail;
        tail.next = node;
        tail = node;
        tail.next = null;

        size++;
   }

   // Get node at specific index (O(n))
   public Node get(int index, Node node){
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
   }

   // Node class for Doubly Linked List
   private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int val){
            this.value = val;
        }

        public Node(int val, Node next, Node prev){
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
   }
}
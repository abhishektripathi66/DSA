package datastructures.heap;

/*
 * Min Heap (Binary Heap)
 *
 * A Min Heap is a complete binary tree where the value of each node
 * is less than or equal to the values of its children.
 * The minimum element is always present at the root.
 *
 * This implementation uses an array to represent the heap:
 *  - For a node at index i:
 *      left child  → 2*i + 1
 *      right child → 2*i + 2
 *      parent      → (i - 1) / 2
 *
 * Core Operations:
 *  - insert(x): Adds a new element and maintains heap property using heapify-up
 *  - extractMin(): Removes and returns the minimum element (root) using heapify-down
 *  - minHeapify(i): Fixes heap property at index i assuming subtrees are already heaps
 *  - buildHeap(): Converts an arbitrary array into a heap in O(n) time
 *  - decreaseKey(i, x): Decreases value at index i and moves it upward if needed
 *  - delete(i): Deletes element at index i using decreaseKey + extractMin
 *
 * Time Complexity:
 *  - insert        → O(log n)
 *  - extractMin    → O(log n)
 *  - minHeapify    → O(log n)
 *  - buildHeap     → O(n)
 *  - decreaseKey   → O(log n)
 *  - delete        → O(log n)
 *
 * Space Complexity:
 *  - O(n) for storing heap elements in array
 *
 * Example:
 *   Insert: [10, 20, 30, 40]
 *   Heap:   [10, 20, 30, 40]  (min element at root)
 *
 * Notes:
 *  - The heap is not a sorted structure; it only guarantees parent ≤ children
 *  - Efficiently used in priority queues, Dijkstra’s algorithm, and heap sort
 */

public class MinHeap {

    private int[] arr;
    private int size;
    private int capacity;

    MinHeap(int c){
        arr = new int[c];
        size = 0;
        capacity = c;
    }


    public static void main(String[] args) {
       
        MinHeap minHeap = new MinHeap(10);

        //Insert elements
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(50);
        minHeap.insert(20);
        minHeap.insert(60);
        minHeap.insert(40);

        System.out.print("Initial Heap: ");
        minHeap.printHeap();  
        //expected: [10, 20, 40, 30, 60, 50] (order may vary but must satisfy heap)

        //extract Min
        System.out.println("Extract Min: " + minHeap.extractMin());

        System.out.print("After extractMin: ");
        minHeap.printHeap();

        //decrease Key (make a value smaller → should move up)
        minHeap.decreaseKey(2, 5);

        System.out.print("After decreaseKey (index 2 -> 5): ");
        minHeap.printHeap();

        //increase Key (make a value larger → should move down)
        minHeap.increaseKey(1, 100);

        System.out.print("After increaseKey (index 1 -> 100): ");
        minHeap.printHeap();

        //delete element at index 2
        minHeap.delete(2);

        System.out.print("After delete index 2: ");
        minHeap.printHeap();
    }
    
    //left child
    private int left(int i){
        return 2*i + 1;
    }

    //right child 
    private int right(int i){
        return 2*i + 2;
    }

    //parent node
    private int parent(int i){
        return (i-1)/2;
    }

    //Time complexity: O(logn)
    private void insert(int x){
        if(size == capacity)
            return;
        size++;
        arr[size-1] = x;

        for(int i=size-1; i!=0 && arr[parent(i)] > arr[i]; ){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    //Time complexity: O(logn)
    //minHeapify can be done if only one violation at current index with correct minHeap order on left and right children
    private void minHeapify(int i){
        int lt = left(i), rt = right(i);
        int smallest = i;

        if(lt<size && arr[lt] < arr[smallest]) //check if left child value is valid or not
            smallest = lt;

        if(rt<size && arr[rt] < arr[smallest]) //check if right child value is valid or not
            smallest = rt;

        if(smallest != i){ //if there is violation in order, swap smallest value with current index i
            swap(i, smallest);
            minHeapify(smallest); //then perform minHeapify on one of the child
        }
    }

    //Time complexity: O(n), it may seem O(nlogn) but afterward not every node takes logn time so it is O(n)
    //given a random array, to rearrange its elements to form a minHeap
    //if inserting elements one by one, then no need to use buildHeap
    private void buildHeap(){

        //minHeapify from last non-leaf node to root
        for(int i=(size-2)/2; i>=0; i--){
            minHeapify(i);
        }
    }

    //Same time complexity as minHeapify
    private int extractMin(){

        if(size == 0)
            return -1;

        if(size == 1){
            size--;
            return arr[0];
        }

        //swap the first(min) and last(max) elements
        //perform minHeapify from 0th index to n-2 before swapped min Value
        swap(0, size-1);
        size--;
        minHeapify(0);
        return arr[size]; //return min value
    }

    //Time complexity: O(logn)
    //used in delete operation
    private void decreaseKey(int i, int x){

        if(i >= size)
            throw new RuntimeException("Invalid index");
        if(x > arr[i])
            throw new RuntimeException("New value is greater than current value");

        arr[i] = x;

        while(i!=0 && arr[parent(i)] > arr[i]){ //check if parent became greater, it is violation and rearrangement needed
            swap(i, parent(i));
            i = parent(i);
        }
    }

    //rarely used in minHeap 
    private void increaseKey(int i, int x){
         if(i >= size)
            throw new RuntimeException("Invalid index");
        if(x < arr[i])
            throw new RuntimeException("New value is smaller than current value");

        arr[i] = x;

        minHeapify(i); //check with children nodes and push it down if needed
    }

    private void delete(int i){
        decreaseKey(i, Integer.MIN_VALUE); //assign smallest possible value and take that to root
        extractMin(); //then call extractMin to remove that value
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

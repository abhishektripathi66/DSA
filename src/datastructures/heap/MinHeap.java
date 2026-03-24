package datastructures.heap;

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
        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(50);
        minHeap.insert(20);
        minHeap.insert(60);
        minHeap.insert(40);

        minHeap.printHeap();
    }
    
    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private int parent(int i){
        return (i-1)/2;
    }


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

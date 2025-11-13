package datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A generic implementation of a Priority Queue using a binary heap.
 *
 * <p>This priority queue supports both natural ordering and custom comparators.
 * It provides efficient insertion and removal of elements based on their priority.</p>
 *
 * <p>Operations complexity:
 * <ul>
 *   <li>Insert: O(log n)</li>
 *   <li>Poll: O(log n)</li>
 *   <li>Peek: O(1)</li>
 * </ul>
 * </p>
 *
 * @param <T> the type of elements held in this priority queue
 */
public class PriorityQueue<T> {

    private final List<T> heap;
    private final Comparator<? super T> comparator;

    /**
     * Constructs a new empty priority queue with natural ordering.
     *
     * <p>Elements must implement {@link Comparable} if no comparator is provided.</p>
     */
    public PriorityQueue() {
        this(null);
    }

    /**
     * Constructs a new empty priority queue with a custom comparator.
     *
     * @param comparator the comparator that will determine the priority order
     */
    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * Inserts a new element into the priority queue.
     *
     * @param value the element to be inserted
     * @throws NullPointerException if the value is null
     */
    public void insert(T value) {
        if (value == null) {
            throw new NullPointerException("Cannot insert null into PriorityQueue");
        }
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    /**
     * Retrieves, but does not remove, the element with the highest priority (root of the heap).
     *
     * @return the element with the highest priority
     * @throws IllegalStateException if the queue is empty
     */
    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        return heap.get(0);
    }

    /**
     * Retrieves and removes the element with the highest priority.
     *
     * @return the removed element
     * @throws IllegalStateException if the queue is empty
     */
    public T poll() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }

        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    /**
     * Checks whether the priority queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Returns the number of elements currently in the priority queue.
     *
     * @return the size of the priority queue
     */
    public int size() {
        return heap.size();
    }

    /**
     * Removes all elements from the priority queue.
     */
    public void clear() {
        heap.clear();
    }

    /**
     * Returns a copy of the internal heap as a list.
     *
     * <p>This is mainly intended for debugging or testing purposes.
     * The returned list does not represent sorted order.</p>
     *
     * @return a list containing all elements in the heap
     */
    public List<T> toList() {
        return new ArrayList<>(heap);
    }

    // -------------------- Private Helper Methods --------------------

    /**
     * Moves the element at the given index up the heap until the heap property is restored.
     * This method is called after inserting a new element.
     */
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(heap.get(index), heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    /**
     * Moves the element at the given index down the heap until the heap property is restored.
     * This method is called after removing the root element.
     */
    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && compare(heap.get(left), heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && compare(heap.get(right), heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    /**
     * Compares two elements using either the provided comparator or their natural ordering.
     *
     * @return a negative integer if a < b, zero if equal, or a positive integer if a > b
     */
    @SuppressWarnings("unchecked")
    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable<? super T>) a).compareTo(b);
    }

    /**
     * Swaps two elements in the internal heap list.
     */
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

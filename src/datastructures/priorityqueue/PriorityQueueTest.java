package datastructures.priorityqueue;


import java.util.Comparator;

/**
 * Demonstrates the usage of the {@link PriorityQueue} data structure.
 *
 * <p>This example shows how to use the priority queue with natural ordering,
 * a custom comparator (max-heap), and custom objects. It also demonstrates
 * handling of edge cases such as polling or peeking from an empty queue.</p>
 */
public class PriorityQueueTest {

    /**
     * Entry point for the PriorityQueue example.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        demonstrateMinHeap();
        demonstrateMaxHeap();
        demonstrateCustomObjects();
        demonstrateEdgeCases();
    }

    private static void demonstrateMinHeap() {
        System.out.println("=== Default (Min-Heap) PriorityQueue Example ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println("Peek (top priority): " + minHeap.peek());
        System.out.println("Polling all elements:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
        System.out.println();
    }

    private static void demonstrateMaxHeap() {
        System.out.println("=== Custom Comparator (Max-Heap) Example ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(8);
        maxHeap.insert(1);

        System.out.println("Peek (top priority): " + maxHeap.peek());
        System.out.println("Polling all elements:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
        System.out.println();
    }

    private static void demonstrateCustomObjects() {
        System.out.println("=== PriorityQueue with Custom Objects ===");
        Comparator<Task> byPriority = Comparator.comparingInt(Task::getPriority);
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(byPriority);

        taskQueue.insert(new Task("Wash dishes", 3));
        taskQueue.insert(new Task("Finish project", 1));
        taskQueue.insert(new Task("Exercise", 2));

        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
        System.out.println();
    }

    private static void demonstrateEdgeCases() {
        System.out.println("=== Edge Case Demonstrations ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        try {
            System.out.println("Attempting to peek an empty queue:");
            pq.peek();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to poll an empty queue:");
            pq.poll();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            System.out.println("Attempting to insert null value:");
            pq.insert(null);
        } catch (NullPointerException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println();
    }

    /**
     * A simple class used to demonstrate custom comparator behavior.
     */
    static class Task {
        private final String name;
        private final int priority;

        /**
         * Constructs a new Task instance.
         *
         * @param name     the name of the task
         * @param priority the priority of the task (lower means higher priority)
         */
        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        /**
         * Returns the priority of this task.
         *
         * @return the task priority
         */
        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return name + " (priority: " + priority + ")";
        }
    }
}
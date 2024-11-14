package queue;


// Queue class implemented using an array
public class Queue {
    int[] queue;
    int front, rear, capacity, size;

    // Constructor to initialize a queue with a given capacity
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue: Add an element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity;  // Circular queue behavior
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 if the queue is empty
        }
        int data = queue[front];
        front = (front + 1) % capacity;  // Circular queue behavior
        size--;
        System.out.println("Dequeued: " + data);
        return data;
    }

    // Peek: Get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Traverse the queue and print its elements
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Driver method for testing the queue implementation
    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue with capacity of 5

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Traverse and print the queue
        System.out.println("Queue after enqueuing elements:");
        queue.traverse(); // Expected output: 10 20 30 40 50

        // Dequeue elements
        queue.dequeue(); // Expected output: Dequeued: 10
        queue.dequeue(); // Expected output: Dequeued: 20

        // Traverse the queue again
        System.out.println("\nQueue after dequeuing elements:");
        queue.traverse(); // Expected output: 30 40 50

        // Peek front element
        System.out.println("\nPeek: " + queue.peek()); // Output: 30

        // Check if the queue is empty
        System.out.println("\nIs queue empty? " + queue.isEmpty()); // Output: false

        // Enqueue more elements
        queue.enqueue(60); // Circular behavior should kick in here
        queue.enqueue(70);

        // Traverse the queue again
        System.out.println("\nQueue after enqueuing more elements:");
        queue.traverse(); // Expected output: 30 40 50 60 70

        // Try to enqueue when the queue is full
        queue.enqueue(80); // Output: Queue is full

        // Dequeue all elements
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Emptying the queue

        // Check if the queue is empty after dequeuing all elements
        System.out.println("\nIs queue empty? " + queue.isEmpty()); // Output: true
    }
}

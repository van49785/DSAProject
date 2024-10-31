public class Queue {
    private int[] queue;
    private int front, rear, size;

    public Queue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue Overflow: Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
        System.out.println("Enqueued " + value + " to the queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println("Dequeued " + value + " from the queue.");
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
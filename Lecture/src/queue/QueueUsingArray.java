package queue;

public class QueueUsingArray {
    private int data[];
    private int rear;
    private int front;
    private int size;

    public QueueUsingArray() {
        data = new int[10];
        rear = -1;
        front = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        rear = -1;
        front = -1;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    void enqueue(int element) throws QueueFullException {
        if (size() == data.length) {
//            throw new QueueFullException();
            doubleCapacity();
        }
        if (size() == 0) {
            front = 0;
        }
//        rear++;
        size++;
        rear = (rear + 1) % data.length;
        if (rear == data.length) {
            rear = 0;
        }
        data[rear] = element;

    }

    int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front++;
//       front = (front + 1) / data.length;
        if (front == data.length) {
            front = 0;
        }
        size--;

        if (size() == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * data.length];
        int index = 0;
        for (int i = front; i < temp.length; i++) {
            data[index] = temp[i];
            index++;
        }
        for (int i = 0; i <= front - 1; i++) {
            data[index] = temp[i];
            index++;
        }

    }
}

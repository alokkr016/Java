package queue;
import java.util.Scanner;
public class QueueUsingLL {
    Node front;
    Node rear;
    int size;

    public QueueUsingLL() {
        //Implement the Constructor
        front = null;
        rear = null;
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size == 0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node newNode = new Node(data);

        if (front == null && rear == null) {
            front = newNode;
            rear = newNode;
            size++;
        } else {
            rear.next = newNode;
            rear = rear.next;
            size++;
        }
    }


    public int dequeue() {
        //Implement the dequeue() function
        if (rear != null && front != null) {
            int temp = front.data;

            front = front.next;
            size--;
            return temp;

        } else {
            return -1;
        }
    }

    public int front() {
        //Implement the front() function
        if (front != null) {
            return front.data;
        } else {
            return -1;
        }
    }
}



class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

 class QueueUse2 {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();

        int q = s.nextInt();

        while (q > 0) {
            int choice, input;
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    input = s.nextInt();
                    queue.enqueue(input);
                    break;

                case 2:
                    System.out.println(queue.dequeue());
                    break;

                case 3:
                    System.out.println(queue.front());
                    break;

                case 4:
                    System.out.println(queue.getSize());
                    break;

                default:
                    System.out.println((queue.isEmpty()) ? "true" : "false");
            }

            q -= 1;
        }

    }

}
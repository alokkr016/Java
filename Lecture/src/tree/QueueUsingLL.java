package tree;

public class QueueUsingLL<T> {
    private NodeGeneric<T> front;
    private NodeGeneric<T> rear;
    int size;

    public QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T element){
        NodeGeneric<T> newNode = new NodeGeneric<>(element);
        if(rear == null){
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if(size == 0){
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        if(size == 1){
            rear = null;
        }
        size--;
        return temp;
    }
}

class NodeGeneric<T> {
    T data;
    NodeGeneric<T> next;

    NodeGeneric(T data){
        this.data = data;
        this.next = null;
    }

}

class QueueFullException extends Exception {

}
class QueueEmptyException extends Exception {

}
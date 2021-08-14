package queue;

public class NodeGeneric<T> {
    T data;
    NodeGeneric<T> next;

    NodeGeneric(T data){
        this.data = data;
        this.next = null;
    }

}

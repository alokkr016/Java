package stack;

public class NodeStack<T>{
    T data;
    NodeStack<T> next;

    NodeStack(T data){
        this.data = data;
        this.next = null;
    }
}

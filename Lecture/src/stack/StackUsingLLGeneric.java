package stack;

public class StackUsingLLGeneric<T> {
    private NodeStack<T> head;
    private int size;

    public StackUsingLLGeneric(){
        head = null;
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    T top() throws StackEmptyException{
        if(size() == 0){
//            StackEmptyException e = new StackEmptyException();
//            throw e;
            throw new StackEmptyException();
        }
        return head.data;
    }
    void push(T element){
        NodeStack<T> newNode = new NodeStack<T>(element);
        newNode.next = head;
        head = newNode;
        size++;

    }
    T pop() throws StackEmptyException{
        if(size() == 0){
            throw new StackEmptyException();
        }
        T tempData = head.data;
        head = head.next;
        size--;
        return tempData;
    }
}

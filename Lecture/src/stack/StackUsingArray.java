package stack;

public class StackUsingArray {
    private int data[];
    private int top;
    public StackUsingArray(){
        data = new int[10];
        top = -1;
    }
    public StackUsingArray(int capacity){
        data = new int[capacity];
        top = -1;
    }
    public boolean isEmpty(){
//        if(top == -1){
//            return true;
//        }
//        else{
//            return false;
//        }
        return top == -1;
    }
    public int size(){
        return top + 1;
    }
    public int top() throws StackEmptyException{
        if(size() == 0){
            //StackEmptyException
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return data[top];
    }
//    public void push(int element) throws StackFullException{
//        if(size() == data.length){
//            //FullSTackE
//            StackFullException e = new StackFullException();
//            throw e;
//
//        }
//        top++;
//        data[top] = element;
//    }
public void push(int element) {
    if(size() == data.length){
        //FullSTackE
        doubleCapacity();
    }
    top++;
    data[top] = element;
}
    public int pop() throws StackEmptyException{
        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        int temp = data[top];
        top--;
        return temp;
    }
    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i = 0;i <= top;i++){
            data[i] = temp[i];
        }
    }

}

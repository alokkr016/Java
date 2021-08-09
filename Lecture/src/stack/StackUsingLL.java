package stack;
/*
Implement a Stack Data Structure specifically to store integer data using a Singly Linked List.
The data members should be private.
You need to implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
5. size() :
It returns the size of the stack at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.
 */
public class StackUsingLL {
    private Node head;
    private int size;
    public StackUsingLL(){
        head = null;
        size = 0;
    }
    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function

        return head == null;
    }

    public void push(int element) {
        //Implement the push(element) function
        Node node = new Node(element);
        node.next = head;
        head = node;
        size++;

    }

    public int pop() {
        //Implement the pop() function
        if(size == 0){
            return -1;
        }
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public int top() {
        //Implement the top() function
        if(size == 0){
            return -1;
        }
        return head.data;
    }
}
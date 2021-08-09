package stack;

public class StackUse {
    public static void main(String[] args) throws StackFullException{
        StackUsingArray stack = new StackUsingArray(3);
        for (int i = 1;i <= 5;i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            try {
                System.out.println(stack.pop());
            }
            catch(StackEmptyException e){

            }
        }
        //Stack Using LinkedList
        System.out.println("Stack Using Linked list | ");
        StackUsingLLGeneric<Integer> stack2 = new StackUsingLLGeneric<>();
        for (int i = 1;i <= 5;i++) {
            stack2.push(i);
        }
        while(!stack2.isEmpty()){
            try {
                System.out.println(stack2.pop());
            }
            catch(StackEmptyException e){

            }
        }
    }
}

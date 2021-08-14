package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseaStack {
//    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
//        //Your code goes here
//        // Without Recursion
//    Stack<Integer> extra2 = new Stack<>();
//    while(!input.isEmpty()) {
//        extra.push(input.pop());
//    }
//    while(!extra.isEmpty()) {
//            extra2.push(extra.pop());
//    }
//    while(!extra2.isEmpty()) {
//            input.push(extra2.pop());
//    }
//    }
    //with Recursion
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        if(input.size() == 0){
            return;
        }
        int temp = input.pop();
        reverseStack(input, extra);
        while(!input.isEmpty()) {
            extra.push(input.pop());
        }
        input.push(temp);
        while(!extra.isEmpty()) {
            input.push(extra.pop());
        }
    }

}
 class Runner11 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        Stack<Integer> input = new Stack<>();

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input.push(Integer.parseInt(values[i]));
        }

        return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> input = takeInput();
        Stack<Integer> empty = new Stack<>();

        ReverseaStack.reverseStack(input, empty);

        while(!input.isEmpty()) {
            System.out.print(input.pop() + " ");
        }

    }
}

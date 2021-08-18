package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumBracketReversal {
    public static int countBracketReversals(String input) {
        //Your code goes here
        if(input.length() % 2 != 0){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) == '{'){
                stack.push(input.charAt(i));
            }
            else if(input.charAt(i) == '}' && stack.isEmpty()){
                stack.push(input.charAt(i));
            }
            else if(input.charAt(i) == '}' && !stack.isEmpty()  && stack.peek() == '}'){
                stack.push(input.charAt(i));
            }
            else {
                stack.pop();
            }

        }
        int count = 0;
        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();
            if(c1 == c2){
                count++;
            }
            if(c1 != c2){
                count += 2;
            }
        }
        return count;
    }

}


 class Runner15 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.println(MinimumBracketReversal.countBracketReversals(br.readLine().trim()));

    }
}
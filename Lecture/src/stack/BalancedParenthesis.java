package stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BalancedParenthesis {
    public static boolean isBalanced(String expression) throws StackEmptyException {
        //Your code goes here
        StackUsingLLGeneric<Character> parenthesis = new StackUsingLLGeneric<>();
        if(expression.charAt(0) == ')' || expression.charAt(0) == '}' || expression.charAt(0) == ']'){
            return false;
        }
        for(int i = 0;i < expression.length();i++){
            if(expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '(') {
                parenthesis.push(expression.charAt(i));
            }
            else{
                if(expression.charAt(i) == ')' && parenthesis.top() == '(' || expression.charAt(i) == '}' && parenthesis.top() == '{' || expression.charAt(i) == ']' && parenthesis.top() == '['){
                    parenthesis.pop();
                }

            }
        }

        return parenthesis.size() == 0;
    }
}


 class Runner1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException, StackEmptyException {
        String expression = br.readLine().trim();
        System.out.println(BalancedParenthesis.isBalanced(expression));
    }
}
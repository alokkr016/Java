package queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
For a given expression in the form of a string,
find if there exist any redundant brackets or not.
It is given that the expression contains only rounded brackets or parenthesis and
the input expression will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by
unnecessary or needless brackets.
 */
public class CheckRedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
        Stack<Character> str = new Stack<Character>();
        Boolean bool = false;
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == ')') {
                int count = 0;
                while (str.peek() != '(') {
                    str.pop();
                    count++;
                }
                str.pop();
                if (count == 0 || count == 1) {
                    return true;
                }
            } else {
                str.push(expression.charAt(i));
            }
            i++;
        }
        return bool;
    }
}

 class Runner12 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();
        System.out.println(CheckRedundantBrackets.checkRedundantBrackets(expression));
    }
}
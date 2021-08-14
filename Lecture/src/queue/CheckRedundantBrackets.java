package queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CheckRedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        //Your code goes here
        Stack<Character> str = new Stack<Character>();
        Boolean bool = false;
        while(expression != ""){
            int count = 0;
        }
    }
}



 class Runner12 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();
        System.out.println(CheckRedundantBrackets.checkRedundantBrackets(expression));
    }
}
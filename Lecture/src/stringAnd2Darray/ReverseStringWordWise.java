package stringAnd2Darray;
import java.util.Scanner;

public class ReverseStringWordWise {
    public static String reverseWordWise(String input) {
        // Write your code here
        String rev = "";
        int i = input.length() - 1;
        String word = "";
        int j = i;
        while (i > 0) {

            if (input.charAt(i) == ' ' && input.charAt(i - 1) != ' ') {
                word = input.substring(i + 1, j + 1);
                rev = rev + word + " ";
                j = i - 1;

            }
            i--;
        }
        String s = input.substring(0,j + 1);
        rev  += s;

        return rev;
    }
}


 class runner4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(ReverseStringWordWise.reverseWordWise(input));
    }
}

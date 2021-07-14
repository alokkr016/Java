package recurssion;
import java.util.Scanner;
public class RemoveDuplicatesRecursively {
    public static String removeConsecutiveDuplicates(String s) {
        // Write your code here
        if(s.length() == 1){
            return s;
        }
        if(s.charAt(0) == s.charAt(1)){
            if(s.length() == 2){
                return s.substring(1);
            }
            return removeConsecutiveDuplicates(s.substring(1));
        }

        return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
    }

}


 class Main24 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String input = s.next();
        System.out.println(RemoveDuplicatesRecursively.removeConsecutiveDuplicates(input));
    }
}
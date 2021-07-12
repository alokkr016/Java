package recurssion;
import java.util.Scanner;
public class StringToInteger {
    public static int convertStringToInt(String input){
        // Write your code here
        if(input.length() == 1){
            int i = input.charAt(0) - 48;
            return i;
        }
        int result = convertStringToInt(input.substring(1));
        return (int)Math.pow(10,(input.length() - 1)) * (int)(input.charAt(0) - 48) + result;
    }
}

class runner20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(StringToInteger.convertStringToInt(input));
    }
}

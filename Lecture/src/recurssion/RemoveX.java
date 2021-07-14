package recurssion;
import java.util.Scanner;
public class RemoveX {
    public static String removeX(String input){
        // Write your code here
        if(input.length() == 1){
            if (input.charAt(0) == 'x'){
                return input.replace("x","");
            }
            else{
                return input;
            }
        }
        if(input.substring(0,1).startsWith("x")){
            return input.replace("x","");
        }

        return input.charAt(0) + removeX(input.substring(1));
    }
}


 class runner18 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(RemoveX.removeX(input));
    }
}

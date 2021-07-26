package recurssion;
import java.util.Scanner;
public class ReplaceCharacterRecursively {
    public static String replaceCharacter(String input, char c1, char c2) {
        /* Your class should be named temp.Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(input.length() == 1){
            if(input.charAt(0) == c1){
                return input.replace(c1,c2);
            }
            else{
                return input;
            }
        }
        if(input.charAt(0) == c1){
            return input.replace(c1,c2);
        }
        return input.charAt(0) + replaceCharacter(input.substring(1),c1,c2);
    }
}


 class Runner23 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        System.out.println(ReplaceCharacterRecursively.replaceCharacter(input, c1, c2));
    }
}

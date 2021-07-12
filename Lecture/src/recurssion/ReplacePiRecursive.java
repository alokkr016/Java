package recurssion;
import java.util.Scanner;

public class ReplacePiRecursive {
    public static String replace(String str) {
        // Write your code here
        if (str.length() <= 1) {
            return str.substring(0,1);
        }
        if (str.substring(0, 2).startsWith("pi")) {
            return str.replace("pi", "3.14");
        }
        return str.charAt(0) + replace(str.substring(1));

    }
}

 class runner19 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(ReplacePiRecursive.replace(input));
    }
}

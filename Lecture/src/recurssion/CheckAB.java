/*
Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.
 */

package recurssion;
import java.util.Scanner;
public class CheckAB {
    public static boolean checkAB(String str) {
        // Write your code here
        if (str.length() == 0) {
            return true;
        }
        if (str.charAt(0) == 'a') {
            if (str.length() > 1 && str.substring(1, 3) == "bb") {
                return checkAB(str.substring(3));
            } else {
                return checkAB(str.substring(1));
            }
        } else {
            return false;
        }
    }
}

/*
============Another solution====================
public class temp.Solution {

	public static boolean checkAB(String s) {
        if (s.length() == 0)
            return true;
        if (s.charAt(0) != 'a')
            return false;
        if (s.length() >= 3 && "abb".equals(s.substring(0, 3)))
            return checkAB(s.substring(3));
        else
            return checkAB(s.substring(1));
    }
}
 */
 class Main31 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(CheckAB.checkAB(input));
    }

}
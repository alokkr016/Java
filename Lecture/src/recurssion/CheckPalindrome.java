package recurssion;
import java.util.Scanner;
public class CheckPalindrome {
    public static boolean isStringPalindrome(String input) {
        // Write your code here
        return pallindrome(input.toLowerCase(),0,input.length() - 1);
    }
    private static boolean pallindrome(String str,int startIndex,int endIndex) {
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(startIndex) != str.charAt(endIndex)) {
            return false;
        }
            String newString = str.substring(startIndex + 1,endIndex);
            boolean result = pallindrome(newString, 0, newString.length() - 1);
            if (result == false) {
                return false;
            } else {
                return true;
            }
        }
    }

/*
return pallindrome(input.toLowerCase(),0,input.length() -1);
    }
    private static boolean pallindrome(String str,int startIndex,int endIndex){
        if(startIndex == (int)str.length() / 2){
            return false;
            }


        boolean result = pallindrome(str,startIndex + 1,endIndex - 1);
        if(str.charAt(startIndex) == str.charAt(endIndex)){
            return true;
        }
        else {
            return false;
        }
    }
}

 */
 class runner16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(CheckPalindrome.isStringPalindrome(input));
    }
}

package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        //Your code goes here
        if(str.length() == 1){
            return true;
        }
        str = str.toLowerCase();

        int size = str.length();
        int j = str.length() - 1;
        boolean bool = true;

            for (int i = 0; i < str.length() / 2; i++) {
                if(str.charAt(i) != str.charAt(j)) {
                    bool = false;
                    break;
                }
                j--;
            }

        return bool;
    }

}




 class Runner2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim();
        } else {
            str = "";
        }

        boolean ans = CheckPalindrome.isPalindrome(str);
        System.out.println(ans);
    }
}
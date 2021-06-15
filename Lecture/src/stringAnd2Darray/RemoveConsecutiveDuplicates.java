package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicates(String str) {
        //Your code goes here
        String newStr = "";
        for(int i = 0;i < str.length() - 1;i++){ // 7
            if(str.charAt(i) != str.charAt(i + 1)){
                newStr += str.charAt(i);
            }

        }
        newStr += str.charAt(str.length() - 1);
        return newStr;
    }

}



 class Runner10 {

    static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

    public static void main (String [] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim ();
        } else {
            str = "";
        }

        String ans = RemoveConsecutiveDuplicates.removeConsecutiveDuplicates(str);

        System.out.println(ans);

    }
}
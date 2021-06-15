package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveCharacter {

    public static String removeAllOccurrencesOfChar(String str, char ch) {
        // Your code goes
        String newStr = "";
        for(int i = 0;i < str.length();i++ ){
            if(str.charAt(i) != ch){
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }

}



 class Runner13 {

    static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

    public static void main (String [] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim ();
        } else {
            str = "";
        }

        char x = br.readLine().charAt(0);

        String ans = RemoveCharacter.removeAllOccurrencesOfChar(str, x);

        System.out.println(ans);

    }
}

package stringAnd2Darray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseEachWord {
    public static String reverseWord(String str){
        String newStr = "";
        for(int i = str.length()-1;i >= 0;i--){
            newStr += str.charAt(i);
        }
        return newStr;
    }
    public static String reverseEachWord(String str) {
        //Your code goes here
        String newStr = "";
        int last_index = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == ' ' && str.charAt(i + 1) != ' '){
                String substr = str.substring(last_index,i);
                substr = reverseWord(substr);
                newStr = newStr + substr + " ";
                last_index = i + 1;
            }
        }
        String s = str.substring(last_index);
        s = reverseWord(s);
        newStr += s;
        return newStr;
    }

}


 class Runner12 {

    static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

    public static void main (String [] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim ();
        } else {
            str = "";
        }

        String ans = ReverseEachWord.reverseEachWord(str);

        System.out.println(ans);

    }
}
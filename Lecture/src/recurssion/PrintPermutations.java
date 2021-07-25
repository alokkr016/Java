package recurssion;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrintPermutations {
    public static void findPermutations(String str) {
        // Write your code here
        findPermutations(str,"");
    }
    public static void findPermutations(String str,String output){
        if (str.length() == 0){
            System.out.println(output);
            return;
        }
        for(int i = 0;i < str.length();i++) {
            String input = str.substring(0,i) + str.substring(i + 1);
            findPermutations(input, output + str.charAt(i));
        }

    }
}


 class Runner45 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        PrintPermutations.findPermutations(str);
    }
}

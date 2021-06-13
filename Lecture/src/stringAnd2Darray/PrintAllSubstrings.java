package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAllSubstrings {

    public static void printSubstrings(String str) {
        //Your code goes here
        for (int j = 0; j < str.length(); j++) {
            for (int i = j; i < str.length(); i++) {
                System.out.println(str.substring(j, i + 1));
            }

        }
    }

}


 class Runner3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim();
        } else {
            str = "";
        }

        PrintAllSubstrings.printSubstrings(str);

    }
}
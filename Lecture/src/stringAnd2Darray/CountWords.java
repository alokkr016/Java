package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWords {
    public static int countWords(String str) {
        //Your code goes here
        if (str.length() != 0) {
            int count = 1;
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

}


class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String str = br.readLine();
        if (str != null) {
            str = str.trim();
        } else {
            str = "";
        }

        int count = CountWords.countWords(str);
        System.out.println(count);
    }
}
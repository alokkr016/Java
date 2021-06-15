package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CompressTheString {
    public static String getCompressedString(String str) {
        //Your code goes here

        String newStr = "";

        int i = 0;
        for (; i < str.length();) { //9
            int wordCount = 1;
            int j = i + 1;
            while (j < str.length()) {
                if (str.charAt(i) == str.charAt(j)) {
                    wordCount++;
                    j++;
                } else {
                    break;

                }

            }
                if (wordCount != 1) {
                    String word = Integer.toString(wordCount);
                    newStr += str.charAt(i) + word;
                } else {
                    newStr += str.charAt(i);
                }
            i  = i + wordCount;

            }
        return newStr;


    }

    }

    //=================wrong++=====================================
//    public static String getCompressedString(String str) {
//        //Your code goes here
//
//
//        String newStr = "";
//        int wordCount = 1;
//        for (int i = 0; i < str.length() - 1; i++) {
//
//            while (str.charAt(i) == str.charAt(i + 1)) {
//                wordCount++;
//                i++;
//                continue;
//            }
//            if(wordCount != 1) {
//                String word = Integer.toString(wordCount);
//                newStr += str.charAt(i) + word;
//            }
//            else{
//                newStr += str.charAt(i);
//            }
//            wordCount = 1;
//        }
//        return newStr;
//    }
//}

    class Runner15 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws NumberFormatException, IOException {
            String str = br.readLine();
            if (str != null) {
                str = str.trim();
            } else {
                str = "";
            }

            String ans = CompressTheString.getCompressedString(str);
            System.out.println(ans);

        }
    }

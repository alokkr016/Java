package recurssion;
import java.util.Scanner;
public class PrintAllCodesString {
    public static void printAllPossibleCodes(String input) {
        // Write your code here
        String s = "";
        printAllPossibleCodes(input, s);
        return;
    }

    public static void printAllPossibleCodes(String str, String output) {
        if (str.length() == 0) {
            System.out.println(output);
            return;
        }
        char ch = str.charAt(0);
        int n = ch - '0';
        char first = (char) ('a' + n - 1);
        printAllPossibleCodes(str.substring(1), output + first);
        if (str.length() >= 2) {
            char ch1 = str.charAt(0);
            char chr2 = str.charAt(1);
            int n1 = ch1 - '0';
            int n2 = chr2 - '0';
            int n3 = (n1 * 10) + n2;
            if (n3 >= 10 && n3 <= 26) {
                char second = (char) ('a' + n3 - 1);
                printAllPossibleCodes(str.substring(2), output + second);
            }

        }
    }
}
/*
===========================================================================

public class solution {
    public static void printAllPossibleCodes(String input) {
        String output="";
       helper(input,output);
        return;

    }
    private static void helper(String input,String output){
        if(input.length()==0)
        {  System.out.println(output);
        return;
        }
        char ch1=helper1(input.charAt(0)-'0');
        helper(input.substring(1),output+ch1);
        if(input.length()>=2)
        {
            int ch2=input.charAt(0)-'0';
            int ch3=input.charAt(1)-'0';
            int x=ch2*10+ch3;
            if(x>=10 && x<=26)
            {
                char ch4=helper1(x);
            helper(input.substring(2),output+ch4);

        }


    }
        return;}
        private static char helper1(int ch){
            return (char)('a'+ch-1);
        }
}
 */
 class runner40 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        PrintAllCodesString.printAllPossibleCodes(input);
    }
}

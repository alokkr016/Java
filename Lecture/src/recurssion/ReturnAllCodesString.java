package recurssion;
import java.util.Scanner;
public class ReturnAllCodesString {
    public static  String[] getCode(String input){
        // Write your code here
        if(input.length() == 0) {
            String out[] = {""};
            return out;
        }
        String temp1[] = getCode(input.substring(1));
        int n = input.charAt(0) - '0';
        char firstChar = (char)('a' + n - 1);
        for(int i = 0; i < temp1.length;i++){
            temp1[i] = firstChar + temp1[i];
        }
        String temp2[] = new String[0];
        if(input.length() >= 2){
            int char1 = input.charAt(0) - '0';
            int char2 = input.charAt(1) - '0';
            int n2 = (char1*10 )+ char2;
            if(n2 >= 10 && n2 <= 26) {
                char firstTwoChar = (char) ('a' + n2 - 1);
                temp2 = getCode(input.substring(2));

                for (int i = 0; i < temp2.length; i++) {
                    temp2[i] = firstTwoChar + temp2[i];
                }
            }
        }
        String []finaloutput = new String[temp1.length + temp2.length];
        int t = 0;
        for(int i = 0;i < temp1.length;i++){
            finaloutput[i] = temp1[i];
            t++;
        }
        for(int i = 0; i < temp2.length;i++){
            finaloutput[t] = temp2[i];
            t++;
        }

        return finaloutput;
    }

}


 class runner39 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        String output[] = ReturnAllCodesString.getCode(input);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}


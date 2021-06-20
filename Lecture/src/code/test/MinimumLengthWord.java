package code.test;
import java.util.Scanner;
public class MinimumLengthWord {

    public static String minLengthWord(String input){

        // Write your code here
        String smallestString = "";
        String tempString = "";
        int length = Integer.MAX_VALUE;
        int k = 0;
        int index = 0;
        int startIndex = 0;
        for(int i = 0; i < input.length();i++){
            if(input.charAt(i) == ' '){
                tempString = input.substring(k,i);
               // System.out.println(k + "   " + i);
                if(tempString.length() < length){
                    length = tempString.length();
                    startIndex = k;
                    index = i;
                }
                k = i + 1;
            }


        }
       // System.out.println(startIndex + "   " + index);
        smallestString = input.substring(startIndex,index);
        return smallestString;
    }
}




 class Main5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        System.out.println(MinimumLengthWord.minLengthWord(str));
    }

}

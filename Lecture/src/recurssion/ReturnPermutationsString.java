package recurssion;
import java.util.Scanner;
public class ReturnPermutationsString {
    public static String[] permutationOfString(String input){
        // Write your code here
        if (input.length() == 0){
            String s[] = {""};
            return s;
        }
        String smallAns[] = permutationOfString(input.substring(1));
        String []finalArray = new String[smallAns.length * input.length()];
        int k = 0;
        for(int i = 0;i < smallAns.length;i++) {
            String currentString = smallAns[i];
            for (int j = 0; j < input.length(); j++) {
                finalArray[k++] = currentString.substring(0,j) + input.charAt(0) + currentString.substring(j);
            }
        }
        return finalArray;
    }

}


 class runner42 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String output[] = ReturnPermutationsString.permutationOfString(input);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}

package recurssion;
import java.util.Scanner;
public class ReturnKeypadCode {
    public static String[] keypad(int n){
        // Write your code here
       if( n == 0){
           String str[] = {""};
           return str;
       }

       String keyNote[] = keypad(n/10);
       String keypadNumber[] = helper(n%10);
       String substring[] = new String[keypadNumber.length * keyNote.length];

       int i = 0;
           for(int j = 0;j < keyNote.length;j++){
               for(int k = 0;k < keypadNumber.length;k++){
                   substring[i] = keyNote[j] + keypadNumber[k];
                   i++;
               }
           }


       return substring;
    }
    public static String[] helper(int n){
        String two[] = {"a","b","c"};
        String three[] = {"d","e","f"};
        String four[] = {"g","h","i"};
        String five[] = {"j","k","l"};
        String six[] = {"m","n","o"};
        String seven[] = {"p","q","r","s"};
        String eight[] = {"t","u","v"};
        String nine[] = {"w","x","y","z"};
        if(n== 2){
            return two;
        }
        else if(n == 3){
            return three;
        }
        else if(n == 4){
            return four;
        }
        else if(n == 5){
            return five;
        }
        else if(n == 6){
            return six;
        }
        else if(n == 7){
            return seven;
        }
        else if(n == 8){
            return eight;
        }
        else if(n == 9){
            return nine;
        }
        else {
            String str[] = {""};
            return str;
        }
    }

}




 class runner28 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        String output[] = ReturnKeypadCode.keypad(input);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}

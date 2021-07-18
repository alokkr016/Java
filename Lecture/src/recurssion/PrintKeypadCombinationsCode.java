package recurssion;
import java.util.Scanner;
public class PrintKeypadCombinationsCode {

    public static void printKeypad(int input){
        // Write your code here
        printKeypad(input,"");
    }
    public static void printKeypad(int input,String str) {
        if (input == 0) {
            System.out.println(str);
            return;
        }
        String[] keys = helper(input % 10);
        printKeypad(input/10,keys[0]+str);
        printKeypad(input/10,keys[1]+str);
        printKeypad(input/10,keys[2]+str);
        if(keys.length == 4){
            printKeypad(input/10,keys[3]+str);
        }
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



 class runner30 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int input = 23;
        PrintKeypadCombinationsCode.printKeypad(input);
    }
}

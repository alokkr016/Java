package recurssion;
import java.util.Scanner;

public class SumOfDigitsRecursive {

    public static int sumOfDigits(int input){
        // Write your code here
        if(input == 0){
            return 0;
        }
        int rem = input % 10;
        input = input / 10;
        return rem + sumOfDigits(input);
    }
}

 class runner17 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(SumOfDigitsRecursive.sumOfDigits(n));
    }
}

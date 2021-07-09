package recurssion;
import java.util.Scanner;
public class Multiplication {
    public static int multiplyTwoIntegers(int m, int n){
        // Write your code here
    if(n == 1){
        return m;
    }
    return m + multiplyTwoIntegers(m, n - 1);
    }
}



 class runner12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println(Multiplication.multiplyTwoIntegers(m, n));
    }
}

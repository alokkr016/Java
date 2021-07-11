package recurssion;
import java.util.Scanner;
public class CountZeros {
    public static int countZerosRec(int input) {
        if (input == 0) {
            return 1;
        }
        if (input < 10) {
            return 0;
        }
        int rem = input % 10;
        if (rem == 0) {
            return 1 + countZerosRec(input / 10);
        }
        else{
            return countZerosRec(input / 10);
        }
    }
}
 class runner13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(CountZeros.countZerosRec(n));
    }
}

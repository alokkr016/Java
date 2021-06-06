package operator.loop;

import java.util.Scanner;

public class ReverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int temp = 0;
        int rev = 0;
        while(n != 0){
            temp = n % 10;

            n = n/10;
            rev = rev * 10 + temp;
        }
        System.out.print(rev);
    }
}

package assignment;

import java.util.Scanner;

public class SumOfEvenAndOddDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int sumEven = 0;
        int sumOdd = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                sumEven = sumEven + digit;
            } else {
                sumOdd = sumOdd + digit;
            }
            num = num / 10;
        }
        System.out.println(sumEven + " " + sumOdd);
    }
}

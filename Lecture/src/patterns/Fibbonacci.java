package patterns;

import java.util.Scanner;

public class Fibbonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num1 = 0;
        int num2 = 1;
        int temp = 0;
        for(int i = 2;i <  n;i++){
            temp = num2;
            num2 = num2 + num1;
            num1 = temp;
        }
        System.out.println(num2);
    }
}

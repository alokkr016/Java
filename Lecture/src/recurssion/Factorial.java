package recurssion;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int n){
        if ( n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println(result);
//        int result = 1;
//        if (n == 1 || n == 0){
//            System.out.println("1");
//            return;
//        }
//        for(int i = 1;i <= n;i++){
//            result *= i;
//        }
//        System.out.println(result);
    }
}

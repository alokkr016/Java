package lecturefour.functions;

import java.util.Scanner;

public class FibonacciNumber {
    public static boolean checkMember(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        if(a == n || b == n){
            return true;
        }
        while(c <= n){
            if(c == n){
                return true;
            }
            c = b;
            b = a + b;
            a = c;
        }
        return false;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(FibonacciNumber.checkMember(n));
        boolean arr[] = new boolean[5];
        System.out.println(arr[0]);

    }

}


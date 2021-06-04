package assignment;

import java.util.Scanner;

public class PowerOfNumber{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        int result = 1;
        if (x == 1 || n == 0){
            System.out.print(1);
            return;
        }
        else if(x == 0){
            System.out.print(0);
            return;
        }
        else{
            int i = 1;
            while(i <= n){
                result = result * x;
                i++;
            }
        }
        System.out.print(result);
    }
}

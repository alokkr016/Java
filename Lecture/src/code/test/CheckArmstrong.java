package code.test;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CheckArmstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();
        int n = parseInt(bin);
        int len = bin.length();
        long sum = n;
        long cubesum = 0;
        while (n > 0) {
            long rem = n % 10;
            n = n/10;
            cubesum = cubesum + (long)(Math.pow(rem, len));



        }
        if(sum == cubesum){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
    }
}
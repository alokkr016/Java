package operator.loop;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();
        int s = parseInt(bin);
        int len = bin.length();

        int temp = 0;
        int newnum = 0;
         for (int i = 0; i <= len; i++){
                 temp = s % 10;
                 newnum += temp*Math.pow(2,i);
                 s = s / 10;

         }
        System.out.print(newnum);
        }

    }


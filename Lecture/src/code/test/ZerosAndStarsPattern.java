package code.test;

import java.util.Scanner;

public class ZerosAndStarsPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 1;
        while (i <= n){
            int j = 1;
            int val = 0;
            while (j <= i - 1){
                System.out.print(val);
                j++;
            }
            System.out.print("*");
            int k = 1;

            while(k <= n - i){
                System.out.print(val);
                k++;
            }
            System.out.print("*");
            int l = 1;

            while(l <= n - i){
                System.out.print(val);
                l++;
            }
            System.out.print("*");
            int m = 1;

            while (m <= i - 1){
                System.out.print(val);
                m++;
            }


            System.out.println();
            i++;
        }

    }
}

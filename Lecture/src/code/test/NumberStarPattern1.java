package code.test;

import java.util.Scanner;

public class NumberStarPattern1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 1;
        int val = n;
        while(i <= n){
            int j = 1;
            val = n;
            while(j <= n - i){
                System.out.print(val);
                val--;
                j++;
            }
            System.out.print("*");
            int k = 1;
            int val2 = i - 1;
            while(k <= i - 1){
                System.out.print(val2);
                k++;
                val2--;
            }
            System.out.println();
            i++;
        }

    }
}

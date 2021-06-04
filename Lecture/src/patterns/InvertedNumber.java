package patterns;

import java.util.Scanner;

public class InvertedNumber {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int i = 1;

            while (i <= n){
                int j = 1;
                int value = n - i + 1;
                while(j <= n - i + 1){
                    System.out.print(value);
                    j++;

                }
                System.out.println();
                i++;
            }
        }
    }

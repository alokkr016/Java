package patterns;

import java.util.Scanner;

public class InvertedNumStar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 1;
        while(i <= n){
            int space = 1;
            while(space <= n - i){
                System.out.print(" ");
                space++;
            }
            int j = 1;
            while(j <= i){
                System.out.print(j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}

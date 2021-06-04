package patterns;

import java.util.Scanner;

public class ReverseAlphabetTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;

        while(i <= n){
            char alpha = 'A';
            int j = 1;
            alpha = (char) (alpha + i - 1);
            while(j <= i){
                System.out.print(alpha);
                j++;
                alpha++;
            }


            System.out.println();
            i++;
        }
    }
}
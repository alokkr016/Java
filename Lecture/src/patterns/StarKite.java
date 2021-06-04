//my most difficult question;

package patterns;

import java.util.Scanner;

public class StarKite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;


        while(i <= (n+1)/2) {
            int spaces = 1;
            while (spaces <= (n + 1) / 2 - i) {
                System.out.print(" ");
                spaces++;
            }

            int j = 1;
            while (j <= i * 2 - 1) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
        int l = (n+1)/2 - 1; // 3
        while(l >= 1){
            int spaces = 1;
            while(spaces <= (n+1)/2 - l) {  // 3 - 3 + 1
                System.out.print(" ");
                spaces++;
            }
            int k = 1;

            while(k <= 2*l - 1){
                System.out.print("*");
                k++;

            }
            System.out.println();
            l--;


        }
    }
}


package patterns;

import java.util.Scanner;

public class InterestingAlphabets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        char alpha = (char)(64 + n);
        while(i <= n){
            int j = 1;
            while(j <= i){
                System.out.print(alpha);
                j++;
                alpha++;
            }
            alpha = (char)(alpha - i - 1);

            System.out.println();
            i++;
        }
    }
}
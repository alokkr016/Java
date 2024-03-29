package patterns;

import java.util.Scanner;

public class StarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while(i <= n){
            int spaces = 1;
            while(spaces <= n - i){
                System.out.print(" ");
                spaces++;
            }
            int j = 1;
            while(j <= 2 * i - 1){
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}

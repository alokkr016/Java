package patterns;

import java.util.Scanner;

public class IsoscalesTriangleV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (i <= n){
            int space = 1;
            while(space <= n - i){
                System.out.print(" ");
                space++;
            }
            int asc = 1;
            int p = i;
            while(asc <= i){
                System.out.print(p);
                asc++;
                p++;
            }
            int val = p - 2;
            int dsc = 1;
            while(dsc <= i - 1){
                System.out.print(val);
                dsc++;
                val--;
            }
            System.out.println();
            i++;
        }
    }
}

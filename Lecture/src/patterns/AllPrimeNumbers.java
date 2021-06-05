package patterns;

import java.util.Scanner;

public class AllPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 2; i <= n;i++){
            if (i == 2 || i == 3){
                System.out.print(i);
                continue;
            }
            boolean prime = false;
            for(int j = 2;j < i;j++){
                if(i % j == 0){
                    prime = true;
                    break;
                }
            }
            if (!prime){
                System.out.print(i);
            }
        }
    }
}
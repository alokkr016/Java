package operator.loop;

import java.util.Scanner;

public class SumorProduct {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int sum = 0;
        int product = 1;

        if (c == 1) {
        for(int i = 1;i <= n;i++){
            sum = sum + i;
        }

        } else if (c == 2) {
            for(int i = 1;i <= n;i++){
                product *= i;
            }

        } else {
            System.out.print("-1");
            return;
        }
        if(c== 1){
            System.out.print(sum);
        }
        else if (c == 2){
            System.out.print(product);
        }
    }
}

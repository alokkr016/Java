package algorithm.ifelse;

import java.util.Scanner;

public class SumOfEvenNumber {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int i = 2;
        int sum = 0;
        while (i <= n){
            if (i % 2 == 0){
                sum = sum + i;
            }
            i++;
        }
        System.out.println(sum);
    }
}

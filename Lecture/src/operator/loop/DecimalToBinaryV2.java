package operator.loop;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DecimalToBinaryV2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();
        int s = parseInt(bin);

        int len = bin.length();
        if(s==0)
        {
            System.out.println(0);
            return;
        }
        int temp = 0;
        int newnum = 0;
        int i = 0;
        int binary[] = new int[40];

        while(s> 0){
            temp = s % 2;
            s = s / 2;
            binary[i++]= temp;


        }
        for(int j = i-1;j >= 0;j--){
            System.out.print(binary[j]);
        }
    }

}
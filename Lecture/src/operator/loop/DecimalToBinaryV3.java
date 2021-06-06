package operator.loop;

import java.util.Scanner;

public class DecimalToBinaryV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s= sc.nextInt();
        long power=1;
        long newnum = 0;


        while(s> 0){
            int  temp = s % 2;
            newnum += temp*power;
            s = s / 2;

            power*=10;

        }
        System.out.print(newnum);
    }

}

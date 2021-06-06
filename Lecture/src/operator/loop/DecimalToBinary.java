package operator.loop;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.next();
        int s = parseInt(bin);
        int len = bin.length();

        int temp = 0;
        int newnum = 0;
        int i = 0;
        while(s != 0){
            temp = s % 2;
            s = s / 2;
            System.out.println("s = "+s);
            System.out.println("temp = " + temp);
            newnum += (int)(temp * Math.pow(10, i));
            System.out.println("newnum= " + newnum);
            i++;

        }
        System.out.print(newnum);
    }

}



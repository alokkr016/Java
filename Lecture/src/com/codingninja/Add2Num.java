package com.codingninja;

import java.util.Scanner;

public class Add2Num {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String q = sn.next();
        System.out.println(q);
        int p = sn.nextInt();
        int r = sn.nextInt();
        int t = sn.nextInt();
        int si = (p*r*t)/ 100;
        System.out.println(si);
        System.out.println("Amount = " + (p + si));
    }

}

package com.codingninja.ifelse;

import java.util.Scanner;

public class Fah2CelTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();
        int gap = s.nextInt();
        int cel;
        while (start <= end){
             cel = 5*((start-32) / 9);
             System.out.println(start + " " + cel);
             start = start + gap;
        }

    }
}

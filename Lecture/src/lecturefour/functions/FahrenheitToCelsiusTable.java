package lecturefour.functions;

import java.util.Scanner;

public class FahrenheitToCelsiusTable {
    public static void printFahrenheitTable(int start, int end, int step) {
        for(int i = start;i <= end;i = i + step){
            int c = (5*(i - 32)/9);
            System.out.println(i + " " + c);

        }

    }
}

    class Runner{

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int start = s.nextInt();
            int end = s.nextInt();
            int step = s.nextInt();
            FahrenheitToCelsiusTable.printFahrenheitTable(start, end, step);
        }
    }
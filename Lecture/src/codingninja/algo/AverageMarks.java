package codingninja.algo;


import java.util.Scanner;

public class AverageMarks {


    public static void main(String[] args) {

        /* Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sn = new Scanner(System.in);
        String name = sn.next();
        int m1 = sn.nextInt();
        int m2 = sn.nextInt();
        int m3 = sn.nextInt();
        int average = (m1+m2+m3) / 3;
        System.out.println(average);

    }

}
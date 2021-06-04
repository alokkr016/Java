package assignment;
import java.lang.Math;
import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int basic = s.nextInt();
        char grade = s.next().charAt(0);
        int allow = 0;
        if (grade == 'A') {
            allow = 1700;
        }
            else if (grade == 'B') {
            allow = 1500;
        }
            else{
                    allow = 1300;
                }

        double hra = 0.2 * basic;
            double da = 0.5 * basic;
            double pf = .11 * basic;
            int total_Salary = (int)(Math.round(basic + hra + da + allow - pf));
        System.out.println(total_Salary);

    }
}

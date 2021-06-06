package operator.loop;

import java.util.Scanner;

public class TermsOfAP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int count = 0;
        while (true) {
            int term = 3 * i + 2;
            if (term % 4 == 0) {
                i++;
                continue;
            }
            System.out.print(term + " ");
            i++;
            count++;
            if (count == n) {
                break;
            }
        }
    }
}

package recurssion;

import java.util.Scanner;

public class CalculatePower {
    public static int power(int x, int n) {
        /* Your class should be named temp.Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(n == 0){
            return 1;
        }
//        if (n == 1){
//            return x;
//        }
        return x * power(x,n - 1);
    }
}


 class Runner1 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int x = s.nextInt();
        int n = s.nextInt();

        System.out.println(CalculatePower.power(x, n));
    }
}
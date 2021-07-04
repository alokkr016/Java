package recurssion;
import java.util.Scanner;
public class SumoOfArray {
    public static int sum(int input[]) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if (input.length == 1){
            return input[0];
        }
        int smallArr[] = new int[input.length - 1];
        for(int i = 1; i < input.length;i++){
            smallArr[i - 1] = input[i];
        }


        return input[0] + sum(smallArr);

    }
}


 class Runner5 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(SumoOfArray.sum(input));
    }
}

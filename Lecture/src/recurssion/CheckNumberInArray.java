package recurssion;
import java.util.Scanner;

public class CheckNumberInArray {
    public static boolean checkNumber(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

//        boolean value = false;
//        System.out.println(input[0]);
        if(input[0] == x){
            return true;
        }
        if(input.length == 1 && input[0] != x){
            return false;
        }
            int[] smallArray = new int[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                smallArray[i - 1] = input[i];
            }


        return checkNumber(smallArray,x);
    }

}

 class Runner6 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(CheckNumberInArray.checkNumber(input, x));
    }
}

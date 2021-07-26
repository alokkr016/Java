package recurssion;
import java.util.Scanner;

public class FirstIndexOfNumber {
    public static int firstIndex(int input[], int x) {
        /* Your class should be named temp.Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        return index(input,x,0);
    }
    private static int index(int arr[], int x, int startIndex){
//        boolean found = false;
        if(startIndex >= arr.length - 1) {
            return -1;
        }
            if(arr[startIndex] == x){
                return startIndex;
            }
            int i = index(arr,x,startIndex + 1);
            return i;
    }


}


 class Runner8 {

    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int x = s.nextInt();
        System.out.println(FirstIndexOfNumber.firstIndex(input, x));
    }
}
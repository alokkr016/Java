package recurssion;
import java.util.Scanner;
public class LastIndexOfNumber {
    public static int lastIndex(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        //return index(input,x,input.length-1);
        return index2(input,x,0);
    }
//    private static int index(int arr[], int x, int startIndex){
////        boolean found = false;
//        if(startIndex < 0) {
//            return -1;
//        }
//        if(arr[startIndex] == x){
//            return startIndex;
//        }
//        int i = index(arr,x,startIndex - 1);
//        return i;
//    }

    private static int index2(int arr[], int x, int startIndex){
    if(startIndex > arr.length - 1){
        return -1;
    }


    int result = index2(arr,x,startIndex + 1);
    if(result != -1) {
        return result;
    }
    if(arr[startIndex] == x) {

        return startIndex;
    }
    else{
        return -1;
    }
//    return result;
    }

}

 class Runner9 {

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
        System.out.println(LastIndexOfNumber.lastIndex(input, x));
    }
}
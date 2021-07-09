package recurssion;
import java.util.Scanner;
import java.util.Arrays;
public class AllIndicesOfNumber {
    public static int[] allIndexes(int input[], int x) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int arr[] = indexes(input,x,0);
        Arrays.sort(arr);
        return arr;
    }
    private static int[] indexes(int arr[],int x,int startIndex){
        if (startIndex > arr.length - 1) {
            int newArr[] = {};
            return newArr;
        }

        int result[] = indexes(arr,x,startIndex + 1);

        if(arr[startIndex] == x) {

            int newArr[] = new int[result.length + 1];

            for(int i = 0; i < result.length;i++){
                newArr[i] = result[i];
            }
            newArr[result.length] = startIndex;
            return newArr;

        }
        return result;
    }

}




 class Runner10 {

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
        int output[] = AllIndicesOfNumber.allIndexes(input, x);
        for(int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
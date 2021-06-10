package array;
import javax.swing.plaf.basic.BasicArrowButton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Sort01 {
    public static int zeroCount(int []arr){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0){
                count++;
            }
        }
        return count;
    }
    public static void sortZeroesAndOne(int[] arr) {
        //Your code goes here
        int zero = zeroCount(arr);

            for (int j = 0;j < zero;j++){
                arr[j] = 0;
            }
            for( int j = zero;j < arr.length;j++ ){
                arr[j] = 1;
            }

            }
        }


class Runner9 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] strNums;
        strNums = br.readLine().split("\\s");


        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            Sort01.sortZeroesAndOne(input);
            printArray(input);

            t -= 1;
        }
    }
}

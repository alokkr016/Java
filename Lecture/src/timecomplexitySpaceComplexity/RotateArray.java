package timecomplexitySpaceComplexity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RotateArray {
    /*
    First solution
     */
    /*
    public static void rotate(int[] arr, int d) {
        //Your code goes here
        while(d != 0) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            d--;
        }

    }
}
*/
/*
Second solution
 */
    /*
    public static void rotate(int[] arr, int d) {
        int extraArray[] = new int[d];
        for(int i = 0;i < d;i++){
            extraArray[i] = arr[i];
        }
        int i = 0;
        for (; i < arr.length - d;i++){ // 1234567
            arr[i] = arr[i + d];
        }
        for(int j =0;j < extraArray.length;j++){
            arr[j + i] = extraArray[j];
        }

    }
}
*/

    /*
    Third solution
     */
    public static void rotate(int[] arr, int d) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr,0,arr.length - d - 1);
        reverse(arr,arr.length - d,arr.length-1);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int startIndex, int endIndex) {

        while (startIndex < endIndex)  {
            swap(arr, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
}


 class Runner1 {

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
            int d = Integer.parseInt(br.readLine().trim());
            RotateArray.rotate(input, d);
            printArray(input);

            t -= 1;
        }
    }
}
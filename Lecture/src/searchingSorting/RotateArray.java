package searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArray {

    public static void rotate(int[] arr, int d) {
        //Your code goes here

//        int j = 0;
//        for(int i = 0;i < d;i++){
//            int temp = arr[0];
//            for(j = 0;j < arr.length - 1;j++ ){
//                arr[j] = arr[j + 1];
//
//            }
//            arr[j] = temp;
//        }
        int k = 0;
        int[]newArr = new int[d];
        int i = 0;
        for(int l = 0;l < d;l++){
            newArr[l] = arr[i];
            i++;
        }
        for(i = d;i < arr.length;i++){
            arr[k] = arr[i];
            k++;
        }

        for(int j = 0;j < d;j++){
            arr[k] = newArr[j];
            k++;
        }
    }
}


class Runner6 {

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
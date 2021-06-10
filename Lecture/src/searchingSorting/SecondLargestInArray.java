package searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondLargestInArray {
    public static void bubbleSort(int[] arr){
        //Your code goes here
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static int secondLargestElement(int[] arr) {
        //Your code goes here
        if (arr.length <= 0){
            return -2147483648;
        }
        bubbleSort(arr);
        int newArr[] = new int[arr.length];
        int k;
        int f = 0;
        for(k = 0;k < arr.length;k++){
            //System.out.print(arr[k]+ "    ");
        }

        System.out.println();
        for(int i = arr.length - 1;i >= 0; i--){
            newArr[f] = arr[i];
            //System.out.print(newArr[f] + "    ");
            f++;
        }
        if(newArr[0] == newArr[1]){
            return -2147483648;
        }
        return newArr[1];
    }

}



 class Runner8 {

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
            int ans = SecondLargestInArray.secondLargestElement(input);
            System.out.println(ans);

            t -= 1;
        }
    }
}
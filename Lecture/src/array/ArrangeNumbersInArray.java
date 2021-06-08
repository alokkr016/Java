package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrangeNumbersInArray {
    public static void arrange(int[] arr, int n) {
     if(n == 0){
        return;
    }
        else if(n % 2 != 0){
         evenodd(arr, n);
         arr[n/2] = n;


        //Your code goes here
    }
        else{
         evenodd(arr, n);

     }
}

    private static void evenodd(int[] arr, int n) {
        int i = 0;
        int  j = 0;
        while (i < n/2){
            arr[i] = j + 1;
            arr[n - i - 1] = arr[i] + 1;
            j = arr[n - i -1];
            i++;

        }
    }
}
     class Runner2 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        public static void printArray(int[] arr) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) throws NumberFormatException, IOException {
            int t = Integer.parseInt(br.readLine().trim());

            while (t > 0) {
                int n = Integer.parseInt(br.readLine());
                int[] arr = new int[n];

                ArrangeNumbersInArray.arrange(arr, n);
                printArray(arr);

                t -= 1;
            }
        }
    }


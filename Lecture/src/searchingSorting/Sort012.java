package searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012 {
     public static int countN(int []arr,int n){
        int count = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == n){
                count++;
            }
        }
        return count;
    }

    public static void sort012(int[] arr) {
        int cnt0 = countN(arr,0);
        int cnt1 = countN(arr,1);
        int cnt2 = countN(arr,2);
        int i = 0;


        while (cnt0 > 0) {
            arr[i] = 0;
            i++;
            cnt0--;
        }

        // Then all the 1s
        while (cnt1 > 0) {
            arr[i] = 1;
            cnt1--;
            i++;
        }

        // Finally all the 2s
        while (cnt2 > 0) {
            arr[i] = 2;
            cnt2--;
            i++;
        }

    }
    }
//=========================================================================================
//        //int []newArr = new int[arr.length];
//        int k = 0;
//        int i = 0;
//        //System.out.println(i + " " + k);
//        for(i = 0; i < arr.length;){
//                if(arr[i] == 0 && k < arr.length && i < arr.length){
//                    arr[k] = 0;
//                    k++;
//                    i++;
//                }
//           // System.out.println(i + " " + k);
//                if(arr[i] == 1 && k < arr.length && i < arr.length){
//                    arr[k] = 1;
//                    k++;
//                    i++;
//                }
//           // System.out.println(i + " " + k);
//
//                if(arr[i] == 2 && k < arr.length && i < arr.length){
//                    arr[k] = 2;
//                    k++;
//                    i++;
//                }
//           // System.out.println(i + " " + k);
//
//        }
//
//
//    }
//}
//
//

 class Runner10 {

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
            Sort012.sort012(input);
            printArray(input);

            t -= 1;
        }
    }
}
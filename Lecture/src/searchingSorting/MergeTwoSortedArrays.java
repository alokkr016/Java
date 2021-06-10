package searchingSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeTwoSortedArrays {
    public static int[] merge(int arr1[], int arr2[]) {
        //Your code goes here

        int newArr[] = new int[arr1.length + arr2.length];
        int j = 0;
        int temp = 0;
        int k = 0;
        int i = 0;
        if(arr1.length == 0){
            return arr2;
        }
        if(arr2.length == 0){
            return arr1;
        }
        for (; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] < arr2[j]) {
                temp = arr1[i];
                i++;
            } else {
                temp = arr2[j];
                j++;
            }
            newArr[k] = temp;
            k++;
        }
        while(i < arr1.length) {
            newArr[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){

            newArr[k] = arr2[j];
            j++;
            k++;
        }

        return newArr;
    }

}

//====================================================================
//public static int[] merge(int arr1[], int arr2[]) {
//    //Your code goes here
//
//    int newArr[] = new int[arr1.length + arr2.length];
//    int j = 0;
//    int temp = 0;
//    int k = 0;
//    int i = 0;
//    if(arr1.length == 0){
//        return arr2;
//    }
//    if(arr2.length == 0){
//        return arr1;
//    }
//    for (; i < arr1.length && j < arr2.length; ) {
//        if (arr1[i] < arr2[j]) {
//            temp = arr1[i];
//            i++;
//        } else {
//            temp = arr2[j];
//            j++;
//        }
//        newArr[k] = temp;
//        k++;
//    }
//    if(i < arr1.length) {
//        for (; k < newArr.length; k++) {
//            newArr[k] = arr1[i];
//            i++;
//        }
//    }
//    if(j < arr2.length){
//        for(;k < newArr.length;k++){
//            newArr[k] = arr2[j];
//            j++;
//        }
//    }
//
//    return newArr;
//}
//
//}
//==================================================================================


class Runner4 {

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

            int[] input1 = takeInput();
            int[] input2 = takeInput();
            int[] ans = MergeTwoSortedArrays.merge(input1, input2);
            printArray(ans);

            t -= 1;
        }
    }
}
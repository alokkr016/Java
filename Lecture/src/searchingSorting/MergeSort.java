package searchingSorting;
import java.util.Scanner;
public class MergeSort {
    public static void mergeSort(int[] input) {  // 2 6 8 5 4 3
        // Write your code here
        if (input.length <= 1) {
            return;
        }
        int startIndex = 0;
        int endIndex = input.length - 1;
        mergeSortArray(input, startIndex, endIndex);
    }

    private static void mergeSortArray(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {


            int mid = (startIndex + endIndex) / 2;
            mergeSortArray(arr, startIndex, mid);
            mergeSortArray(arr, mid + 1, endIndex);
            merge(arr, startIndex, endIndex);
        }
    }

    private static void merge(int[] arr, int startIndex, int endIndex) {
        int[] newArray = new int[arr.length];
        int mid = (startIndex + endIndex) / 2;
//        for (int i = 0; i < arr.length; )
        int i = 0;
        int halfIndex = mid + 1;
        while(startIndex <= mid && halfIndex <= endIndex);
        {
            if (arr[startIndex] < arr[halfIndex]) {
                newArray[i] = arr[startIndex];
                startIndex++;
                i++;
            }
            if (arr[startIndex] > arr[halfIndex]) {
                newArray[i] = arr[halfIndex];
                halfIndex++;
                i++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = newArray[k];
        }
    }
}

 class runner24 {
    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void printArray(int input[]) {
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        MergeSort.mergeSort(input);
        printArray(input);
    }
}

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
            merge(arr, startIndex, endIndex, mid);
        }
    }



    public static void merge(int []arr, int startIndex, int endIndex,int mid) {
        int n1 = mid  - startIndex + 1;
        int n2 =  endIndex - mid;
        int []arr1 = new int[n1];
        int []arr2 = new int[n2];

        for (int i = 0; i < n1; i++)
            arr1[i] = arr[startIndex + i];
        for (int j = 0; j < n2; j++)
            arr2[j] = arr[mid + 1 + j];
        int j = 0;
        int k = 0;
        int i = startIndex;

        while(j < arr1.length && k < arr2.length){
            if(arr1[j] < arr2[k]){
                arr[i] = arr1[j];
                j++;
            }
            else{
                arr[i] = arr2[k];
                k++;
            }
            i++;

        }
        while(j < arr1.length){

            arr[i] = arr1[j];
            i++;
            j++;
        }
        while(k < arr2.length){
            arr[i] = arr2[k];
            i++;
            k++;
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

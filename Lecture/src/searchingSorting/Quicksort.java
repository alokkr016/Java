package searchingSorting;
import java.util.Scanner;

public class Quicksort {

    // method to find the partition position
//    public static int partition(int array[], int low, int high) {
//
//        // choose the rightmost element as pivot
//        int pivot = array[high];
//
//        // pointer for greater element
//        int i = (low - 1);
//
//        // traverse through all elements
//        // compare each element with pivot
//        for (int j = low; j < high; j++) {
//            if (array[j] <= pivot) {
//
//                // if element smaller than pivot is found
//                // swap it with the greatr element pointed by i
//                i++;
//
//                // swapping element at i with element at j
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//
//        }
//
//        // swapt the pivot element with the greater element specified by i
//        int temp = array[i + 1];
//        array[i + 1] = array[high];
//        array[high] = temp;
//
//        // return the position from where partition is done
//        return (i + 1);
//    }
//
//    public static void quickSort(int array[], int low, int high) {
//        if (low < high) {
//
//            // find pivot element such that
//            // elements smaller than pivot are on the left
//            // elements greater than pivot are on the right
//            int pi = partition(array, low, high);
//
//            // recursive call on the left of pivot
//            quickSort(array, low, pi - 1);
//
//            // recursive call on the right of pivot
//            quickSort(array, pi + 1, high);
//        }
//    }
//
//    public static void quickSort(int[] input) {
//
//        quickSort(input, 0, input.length - 1);
//    }
//
//}
//

// Quick sort in Java

 	 public static void quickSortAlgo(int[] input, int startIndex, int endIndex) {
         // your code goes here
         if(startIndex >= endIndex){
             return;
         }

         int pivot = makePivot(input,startIndex,endIndex);
         quickSortAlgo(input, startIndex, pivot - 1);
         quickSortAlgo(input,pivot + 1,endIndex);
     }
     public static void swap(int []arr,int index1, int index2){
         int temp = arr[index1];
         arr[index1] = arr[index2];
         arr[index2] = temp;
     }
     public static int makePivot(int []arr,int startIndex,int endIndex) {

             int pivot = arr[startIndex];
             int count = 0;
             for (int i = startIndex + 1; i <= endIndex; i++) {

                 if (arr[i] <= pivot) {
                     count++;
                 }
             }
             int pivotpos = count + startIndex;
             int temp = arr[pivotpos];
             arr[pivotpos] = arr[startIndex];
             arr[startIndex] = temp;

             int i = startIndex;
             int j = endIndex;
             while (i < pivotpos && j > pivotpos) {
                 if (arr[i] < arr[pivotpos]) {
                     i++;
                 }
                 else if (arr[j] > arr[pivotpos]) {
                     j--;
                 }
                 else {
                     swap(arr, i, j);
                     i++;
                     j--;

                 }


             }

             return pivotpos;
         }

     public static void quickSort(int[] input) {

         quickSortAlgo(input, 0, input.length - 1);
     }

 }



 class Runner26 {

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

        Quicksort.quickSort(input);
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

package priorityQueues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InPlaceHeapSort {
    //Ascending
    public static void  insertIntoVirtualHeap2(int arr[],int i){
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        while(childIndex > 0){
            if(arr[childIndex] > arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else{
                return;
            }
        }
    }
    public static int removeFromVirtualHeap2(int arr[],int heapSize ) {
        int ans = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;
        int maxIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heapSize){
            if(arr[leftChildIndex] > arr[maxIndex]){
                maxIndex = leftChildIndex;
            }
            if(arr[rightChildIndex] > arr[maxIndex]){
                maxIndex = rightChildIndex;
            }
            if(index == maxIndex){
                break;
            }
            else{
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[index];
                arr[index] = temp;
                index = maxIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }
        return  ans;
    }

    //Descending
    public static void  insertIntoVirtualHeap(int arr[],int i){
        int childIndex = i;
        int parentIndex = (childIndex - 1)  / 2;
        while(childIndex > 0){
            if(arr[childIndex] < arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1);
            }
            else{
                return;
            }
        }
    }
    public static int removeFromVirtualHeap(int arr[],int heapSize ) {
        int temp = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heapSize) {
            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }
            if (arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }
            if (minIndex != index) {
                int temp2 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp2;
                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            } else {
                break;
            }
        }
        return temp;
    }

    public static void inplaceHeapSort(int arr[]) {
        //Ascending
        for(int i = 0;i < arr.length; i++){
            insertIntoVirtualHeap2(arr,i);
        }

        //Second part of the question
        for (int i = 0;i < arr.length;i++){
            arr[arr.length - 1 - i] = removeFromVirtualHeap2(arr,arr.length - i);
        }

//      Descending
        for(int i = 0;i < arr.length; i++){
            insertIntoVirtualHeap(arr,i);
        }

        for (int i = 0;i < arr.length;i++){
            arr[arr.length - 1 - i] = removeFromVirtualHeap(arr,arr.length - i);
        }
    }
}

    class Main3 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        static StringTokenizer st;

        public static void main(String[] args) throws NumberFormatException, IOException {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int input[] = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            InPlaceHeapSort.inplaceHeapSort(input);
            for (int i : input) {
                System.out.print(i + " ");
            }
        }

    }
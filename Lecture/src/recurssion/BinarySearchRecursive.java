package recurssion;
import java.util.Scanner;
public class BinarySearchRecursive {
    public static int binarySearch(int input[], int element) {
        // Write your code here
        return binarySearch(input,element,0,input.length - 1);
    }
    public static int binarySearch(int []arr,int x,int startIndex,int endIndex){
        if(startIndex == endIndex){
            if(arr[startIndex] == x){
                return startIndex;
            }
            else{
                return -1;
            }
        }
        int middleIndex = (startIndex + endIndex) / 2;
        if(x == arr[middleIndex]){
            return middleIndex;
        }
        if(x  > arr[middleIndex]){
            startIndex = middleIndex + 1;
        }
        if(x < arr[middleIndex]){
            endIndex = middleIndex - 1;
        }
        return binarySearch(arr,x,startIndex,endIndex);
    }
}




 class runner33 {
    static Scanner s = new Scanner(System.in);
    public static int[] takeInput() {
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int element = s.nextInt();
        System.out.println(BinarySearchRecursive.binarySearch(input, element));
    }
}

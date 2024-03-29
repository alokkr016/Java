package timecomplexitySpaceComplexity;
import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckArrayRotation {
    public static int arrayRotateCheck(int[] arr) {
        int index = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                index = i;
            }
        }
        return index;
    }
}
        //Your code goes here
//        int count = 0;
//        boolean checkSorted = false;
//        while (!checkSorted) {
//
//            int temp = arr[0];
//            for (int i = 0; i < arr.length - 1; i++) {
//                arr[i] = arr[i + 1];
//            }
//            arr[arr.length - 1] = temp;
//            count++;
//            checkSorted = sorted(arr);
//        }
//        return count;
//    }
//
//    public static boolean sorted(int arr[]){
//        boolean result = true;
//        for(int i = 0;i < arr.length - 1;i++){
//            if(arr[i] < arr[i + 1]){
//                result = true;
//            }
//            else{
//                result = false;
//                break;
//            }
//        }
//        return result;
//    }
//
//}


 class Runner2 {

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
            int ans = CheckArrayRotation.arrayRotateCheck(input);
            System.out.println(ans);

            t -= 1;
        }
    }
}
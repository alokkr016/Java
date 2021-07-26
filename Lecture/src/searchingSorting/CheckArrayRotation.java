
package searchingSorting;
/*You have been given an integer array/list(ARR) of size N. It has been sorted(in increasing order) and then rotated by some number 'K' in the right hand direction.
Your task is to write a function that returns the value of 'K', that means, the index from which the array/list has been rotated.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckArrayRotation {

    public static int arrayRotateCheck(int[] arr) {
        if (arr.length == 0){
            return 0;
        }
        int minIndex = Integer.MIN_VALUE;
        int min = arr[0];
        for(int i = 1;i < arr.length-1;i++){
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

}


//===================================================
//   public class temp.Solution {

//     public static int arrayRotateCheck(int[] arr){
//     	//Your code goes here


//         int n = arr.length;
//         if(n==0)
//             return 0;
//         int min = Integer.MAX_VALUE, min_index = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++)
//         {
//             if (min > arr[i])
//             {
//                 min = arr[i];
//                 min_index = i;
//             }
//         }
//         return min_index;
//     }
//   }

//=====================================================================
//    public static boolean checkIfInAsc(int[] newArr) {
//
//        boolean bool = true;
//        for (int i = 0; i < newArr.length - 1; i++) {
//            if (newArr[i] > newArr[i + 1]) {
//                bool = false;
//                break;
//            }
//
//        }
//        return bool;
//    }
//
//    public static int[] rotation(int[] arr) {
//        int[] newArr = new int[arr.length];
//        for (int i = 0; i < arr.length - 1; i++) {
//            newArr[arr.length - 1] = arr[0];
//            newArr[i] = arr[i + 1];
//
//        }
//        return newArr;
//
//    }
//
//    public static int arrayRotateCheck(int[] arr) {
//        if (arr.length <= 0){
//            return 0;
//        }
//        //Your code goes here
//        int rot = 0;
//        int newArr[] = new int[arr.length];
//        newArr = arr;
//        while (true) {
//            newArr = rotation(newArr);
//            rot++;
//
//            boolean bool = checkIfInAsc(newArr);
//            if (bool == true) {
//                break;
//            }
//
//
//        }
//
//        return rot;
//    }
//
//}

    class Runner9 {

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

            while (t > 0) {

                int[] input = takeInput();
                int ans = CheckArrayRotation.arrayRotateCheck(input);
                System.out.println(ans);

                t -= 1;
            }
        }
    }
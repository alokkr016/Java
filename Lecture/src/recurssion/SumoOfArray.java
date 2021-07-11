package recurssion;
import java.util.Scanner;
public class SumoOfArray {

    //    public static int sum(int input[]) {
//        if(input.length == 1){
//            return input[0];
//        }
//        int smallArr[] = new int[input.length - 1];
//        for(int i = 1;i < input.length;i++){ smallArr[i - 1] = input[i];
//        }
//        int result = sum(smallArr);
//        return input[0] + result;
//
//    }
//}
    /*
    ===============================================================================================
     */
    public static int sum(int input[]) {
        return sum2(input, 0);
    }

    private static int sum2(int[] arr, int startIndex) {
        if (startIndex > arr.length - 1) {
            return 0;
        }
        int result = sum2(arr, startIndex + 1);
        return arr[startIndex] + result;
    }
}

 class Runner5 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        System.out.println(SumoOfArray.sum(input));
    }
}

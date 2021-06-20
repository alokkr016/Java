package code.test;

import java.util.Scanner;

public class Leadersinarray {
    public static void leaders(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++)
        {
            int j;
            for (j = i + 1; j < size; j++)
            {
                if (arr[i] <=arr[j])
                    break;
            }
            if (j == size) // the loop didn't break
                System.out.print(arr[i] + " ");
        }
//        int largest = Integer.MIN_VALUE;
//        int[] newArr = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            if (input[i] > largest) {
//                largest = input[i];
//            }
//            int j = i + 1;
//            int k = 0;
//            newArr[k] = input[i];
//            while (j < input.length) {
//                k += 1;
//                if (input[i] > input[j]) {
//                    newArr[k] = input[j];
//                }
//            }
//
//        }
//        for (int i = 0; i < newArr.length; i++) {
//            if (newArr[i] != 0) {
//                System.out.print(newArr[i] + " ");
//            }
//        }
    }
}


 class Runner9 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++){
            input[i] = s.nextInt();
        }
        Leadersinarray.leaders(input);
    }

}

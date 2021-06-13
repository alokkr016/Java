package searchingSorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfTwoArrays {
    public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
        //Your code goes here
        int carry = 0;

        int i = arr1.length - 1; // 2
        int j = arr2.length - 1; // 1
        int f = output.length - 1; // 3
        int n = 0;
        int min = Math.min(i,j); //1
        while(min >= 0){

                    if(f == 0){
                        output[f] = carry;
                        return;
                    }
                    int ans = arr1[i] + arr2[j] + carry;
                    n = ans % 10;
                    carry = ans / 10;
                    output[f] = n;
                    i--;
                    j--;
                    f--;
                    min--;
                }
        for(int m = f; m >= 0;m--){
            if(m == 0){
                output[m] = carry;
                break;
            }
            if(i >= 0){
                int k = arr1[i] + carry;
                int g = k % 10;
                carry = k / 10;
                output[m] = g;
                i--;
            }

            if(j >= 0){
                int k = arr2[j] + carry;
                int g = k % 10;
                carry = k / 10;
                output[m] = g;
                j--;
            }
        }
            }
        }






 class Runner11 {

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

            int[] arr1 = takeInput();
            int[] arr2 = takeInput();

            int[] output = new int[1 + Math.max(arr1.length, arr2.length)];

            SumOfTwoArrays.sumOfTwoArrays(arr1, arr2, output);
            printArray(output);

            t -= 1;
        }
    }
}
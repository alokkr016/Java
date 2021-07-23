package recurssion;

import java.util.Scanner;
public class PrintSubsetSumToK {
    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here
        int output[] = new int[0];
        printSubsetsSumTok(input,k,0,output);
    }
    public static void printSubsetsSumTok(int arr[],int n,int sI,int output[]){
        if(sI == arr.length){
            if (n == 0){
                for(int i = 0;i < output.length;i++){
                    System.out.print(output[i] + " ");
                }
                System.out.println();
                return;
            }
            else{
                return;
            }
        }
        printSubsetsSumTok(arr,n,sI + 1,output);
        int newOutput[] = new int[output.length + 1];
        int i = 0;
        for (; i < output.length;i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = arr[sI];
        printSubsetsSumTok(arr,n - arr[sI],sI + 1,newOutput);
    }
}


 class runner38 {
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
        int k = s.nextInt();
        PrintSubsetSumToK.printSubsetsSumTok(input, k);
    }
}

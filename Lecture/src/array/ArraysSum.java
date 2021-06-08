package array;

import java.util.Scanner;

public class ArraysSum {
    public static void sum(int n[]){
        int sum = 0;
        for(int i = 0;i < n.length;i++){
            sum = sum + n[i];
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 1;
        while(i <= n){
            int arrsize = s.nextInt();
           int arr[] =  new int[arrsize];
           for(int j = 0;j < arr.length;j++){
             arr[j] = s.nextInt();

           }
           sum(arr);
           i++;
        }
    }
}

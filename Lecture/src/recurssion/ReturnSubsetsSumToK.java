package recurssion;
import java.util.Scanner;
public class ReturnSubsetsSumToK {
    public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here
        return subsetsSumK(input, k, 0);
    }
    public static int[][] subsetsSumK(int arr[], int n, int sIndex){
        if(sIndex == arr.length){
            if(n == 0){
                return new int[1][0];
            }
            else{
                return new int[0][0];
            }
        }
        int [][] temp1 = subsetsSumK(arr, n - arr[sIndex], sIndex+1);
        int [][] temp2 = subsetsSumK(arr, n, sIndex+1);
        int [][] output = new int[temp1.length + temp2.length][];
        int l = 0;
        for(int i = 0; i < temp2.length;i++){
            output[i] = new int[temp2[i].length];
            for(int j = 0;j < temp2[i].length;j++){
                output[i][j] = temp2[i][j];
            }
            l++;
        }
        for(int i = 0;i < temp1.length;i++){
            output[i + l] = new int[temp1[i].length + 1];
            output[i + l][0] = arr[sIndex];
            for(int j  = 1; j <= temp1[i].length;j++){
                output[i + l][j] = temp1[i][j -1];
            }
        }
        return output;
    }
}



 class runner36 {
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
        int output[][] = ReturnSubsetsSumToK.subsetsSumK(input, k);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}

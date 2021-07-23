package recurssion;
import java.util.Scanner;
public class ReturnSubsetOfAnArray {

    public static int[][] subsets(int input[]){
        return subsets(input,0);
    }
    public static int[][] subsets(int []arr, int sI){
        if(sI == arr.length){
            int ans[][] = new int[1][0];
            return ans;
        }
        int smallArray[][] = subsets(arr,sI + 1);
        int finalArray[][] = new int[2*smallArray.length][];
        int k = 0;
        for (int i = 0;i < smallArray.length;i++){
            finalArray[i] = new int[smallArray[i].length];
            for(int j = 0; j < smallArray[i].length;j++){
                finalArray[i][j] = smallArray[i][j];
            }
            k++;
        }
        for (int i = 0;i < smallArray.length;i++) {
            finalArray[i + k] = new int[smallArray[i].length + 1];
            finalArray[k + i][0] = arr[sI];

            for (int j = 1; j <= smallArray[i].length; j++) {
                finalArray[i + k][j] = smallArray[i][j - 1];
            }
        }
        return finalArray;

    }

}



    class runner34 {

    public static int[] takeInput() {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int output[][] = ReturnSubsetOfAnArray.subsets(input);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}

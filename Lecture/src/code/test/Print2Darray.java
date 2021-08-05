package code.test;
/*
Given a 2D integer array with n rows and m columns. Print the 0th row from input n times, 1st row n-1 times…..(n-1)th row will be printed 1 time.
Input format :

Line 1 : No of rows(n) & No of columns(m) (separated by space)

Line 2 : Row 1 elements (separated by space)

Line 3 : Row 2 elements (separated by space)

Line 4 : and so on
 */
import java.util.Scanner;
public class Print2Darray {

    public static void print2DArray(int input[][]) {
        // Write your code here
        int rows = input.length;
        if (rows == 0){
            return;
        }
        int column1 = input[0].length;
        int n = rows;  //3
        for (int i = 0; i < rows;) {
            int k = column1 - i;
            while(k > 0) {
                for (int j = 0; j < column1; j++) {
                    System.out.print(input[i][j] + "   ");
                }
                System.out.println();
                k--;
            }
            i++;
        }

    }
}
/*
public static void print2DArray(int arr[][]){
        int rows = arr.length;
        int columns = arr[0].length;
        for(int i = 0;i < rows;i++){
            int j = 0;

            while(j < rows - i){
                for(int m = 0; m < arr[i].length;m++){
                    System.out.print(arr[i][m] + " ");
                }
                System.out.println();
                j++;
            }

        }

}
}
 */

 class Main4 {

    static Scanner s = new Scanner(System.in);

    public static int[][] takeInput(){
        int numRows = s.nextInt();
        int numCols = s.nextInt();
        int[][] input = new int[numRows][numCols];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                input[i][j] = s.nextInt();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[][] input = takeInput();
        Print2Darray.print2DArray(input);
    }
}

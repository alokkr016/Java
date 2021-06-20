package code.test;
import java.util.Scanner;
public class Print2Darray {
//    public static void printNo(int i,int input[][]){
//        int column1 = input[0].length;
//
//    }
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

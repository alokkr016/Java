package stringAnd2Darray;
/*
3 3
1    2    3
4    5    6
7    8    9

1    2    3
1    2    3
1    2    3
4    5    6
4    5    6
7    8    9
 */
import java.util.Scanner;
public class Print2DArray {
    public static void print2DArray(int arr[][]){
        int rows = arr.length;
        int columns = arr[0].length;
        int k;
        for(int i = 0; i < rows; i++){
            k = rows - i;
            while(k > 0) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(arr[i][j] + "  ");
                }
                System.out.println();
            k--;
            }
        }
    }

}



 class Main3 {

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
        Print2DArray.print2DArray(input);
    }
}
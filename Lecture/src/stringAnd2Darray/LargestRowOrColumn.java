package stringAnd2Darray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestRowOrColumn {
    public static void findLargest(int mat[][]){
        //Your code goes here
        int col_largest  = Integer.MIN_VALUE;
        int row_largest  = Integer.MIN_VALUE;
        int rows = mat.length;
        if(rows == 0){
            System.out.println("row " + "0" + " " + row_largest);
            return;
        }
        int cols = mat[0].length;
        int col_largetst_index = -1;
        int row_larget_index = -1;
        for(int i = 0;i < cols;i++){
            int sum = 0;
            for(int j = 0; j <rows;j++){
                sum += mat[j][i];
            }
            if(sum > col_largest){
                col_largest = sum;
                col_largetst_index = i;
            }
        }
        for(int i = 0; i < rows; i++){
            int sum  = 0;
            for (int j = 0;j < cols;j++){
                sum += mat[i][j];
            }
            if(sum > row_largest){
                row_largest = sum;
                row_larget_index = i;
            }
        }
        if(row_largest >= col_largest){
            System.out.println("row " + row_larget_index + " " + row_largest);
        }
        else{
            System.out.println("column " + col_largetst_index + " " + col_largest);
        }
    }

}

class Runner6 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int n_rows = Integer.parseInt(strRowsCols[0]);
        int m_cols = Integer.parseInt(strRowsCols[1]);

        if (n_rows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[n_rows][m_cols];

        for (int row = 0; row < n_rows; row++) {
            String[] strNums;
            strNums = br.readLine().trim().split("\\s");

            for (int col = 0; col < m_cols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[][] mat = take2DInput();

            LargestRowOrColumn.findLargest(mat);
            System.out.println();

            t -= 1;
        }
    }
}

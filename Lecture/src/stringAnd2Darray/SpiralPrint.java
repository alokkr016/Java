package stringAnd2Darray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SpiralPrint {
    public static void spiralPrint(int matrix[][]) {
        //Your code goes here
        int rows = matrix.length;
        if(rows==0){
            return;
        }
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        int total_element = rows*columns;
        while(total_element > 0){
            for(int i = top; i <= top; i++){
                for(int j = left; j <= right;j++){
                    System.out.print(matrix[i][j] + " ");
                    total_element--;
                }
            }
            top++;

            for(int j = right;j <=right ;j++){ //3

                for(int k = top;k <= bottom;k++){

                    System.out.print(matrix[k][j] +" ");
                    total_element--;
                }
            }
            right--;

            for(int i = bottom;i <= bottom;i++){
                for(int j = right;j >= left;j--){
                    System.out.print(matrix[i][j] + " ");
                    total_element--;
                }
            }
            bottom--;

            for(int i = left; i <= left; i++){ //0 <= 0
                for(int j = bottom;j >= top;j--){

                    System.out.print(matrix[j][i]+ " ");
                    total_element--;
                }
            }
            left++;

        }

    }
}


 class Runner8 {

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

            SpiralPrint.spiralPrint(mat);
            System.out.println();

            t -= 1;
        }
    }
}
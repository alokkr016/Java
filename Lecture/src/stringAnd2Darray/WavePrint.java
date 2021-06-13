package stringAnd2Darray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class WavePrint {
    public static void wavePrint(int mat[][]) {
        //Your code goes here
        int rows = mat.length;
        if(rows==0){
            return;
        }
        int columns = mat[0].length;
        for (int i = 0; i < columns; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(mat[j][i] + " ");
                }
            }

            else {
                for (int j = rows - 1; j >= 0; j--) {
                    System.out.print(mat[j][i] + " ");
                }
            }

        }

    }
}

 class Runner7 {

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

            WavePrint.wavePrint(mat);
            System.out.println();

            t -= 1;
        }
    }
}

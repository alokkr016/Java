package dynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumCostPath {

    public static int minCostPath(int[][] input) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(input.length);
        for(int i=0; i < input.length; i++) {
            arr.add(new ArrayList());
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length;j++) {
                arr.get(i).add(input[i][j]);
            }
        }
//        return minCostPath(arr,0,0);

        int memoization[][] = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++){
                memoization[i][j] = -1;
            }
        }
//        return minCostPath(input,0,0,memoization);
        return minCostPathDP(input);
    }
    public static int minCostPath(int[][] input, int i, int j,int [][]memoization) {
        int m = input.length;
        int n = input[0].length;


        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (i == m - 1 && j == n - 1) {
            memoization[i][j] = input[i][j];
            return memoization[i][j];
        }

        if(memoization[i][j] != -1){
            return memoization[i][j];
        }

        int op1 = minCostPath(input, i, j + 1, memoization);
        int op2 = minCostPath(input, i + 1, j, memoization);
        int op3 = minCostPath(input, i + 1, j + 1, memoization);

        memoization[i][j] = input[i][j] + Math.min(op1,Math.min(op2,op3));
        return memoization[i][j];
    }

    public static int minCostPathDP(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int [][]memoization = new int[m][n];

        memoization[m - 1][n - 1] = input[m - 1][n - 1];

        for(int j = n - 2;j >= 0;j--){
            memoization[m - 1][j] = memoization[m - 1][j + 1] + input[m - 1][j];
        }

        for(int i = m - 2;i >= 0;i--){
            memoization[i][n - 1] = input[i][n - 1] + memoization[i + 1][n - 1];
        }

        for(int i = m - 2;i >= 0;i--){
            for(int j = n - 2;j >= 0;j--){
                memoization[i][j] = input[i][j] + Math.min(memoization[i + 1][j + 1],Math.min(memoization[i][j + 1],memoization[i + 1][j]));
            }
        }

        return  memoization[0][0];
    }

    public static int minCostPath(ArrayList<ArrayList<Integer>> input,int i,int j) {
        int  m = input.size();
        int n = input.get(0).size();

        if(i == m - 1 && j == n - 1){
            return input.get(i).get(j);
        }
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }
        int op1 = minCostPath(input,i,j + 1);
        int op2 = minCostPath(input,i + 1,j);
        int op3 = minCostPath(input,i + 1,j + 1);

        return input.get(i).get(j) + Math.min(op1, Math.min(op2, op3));
    }

//    public static void main(String[] args) {
//        int arr[][] = {
//                {3, 4, 1, 2},
//                {2, 1, 8, 9},
//                {4, 7, 8, 1}
//        };
//        minCostPath(arr);
//
//    }
}




 class Runner8 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums;
            strNums = br.readLine().trim().split("\\s");

            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(MinimumCostPath.minCostPath(mat));
    }
}
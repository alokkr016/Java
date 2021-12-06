package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int dfs(String[] edge, int n) {
        boolean [][]visited = new boolean[n][n];
        int count = 0;
        for(int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                if(!visited[i][j]  && edge[i].charAt(j) == '1'){
                    count = Math.max(count, _dfs(edge,i,j,visited,n));
                }
            }
        }
        return count;
    }

    public static int _dfs(String []edge,int i, int j, boolean[][]visited,int n){
        visited[i][j] = true;
        int count = 1;

        for (int m = 0;m < 4;m++){
            int newx = i + dir[m][0];
            int newy = j + dir[m][1];

            if(valid(newx,newy,n) && edge[newx].charAt(newy) == '1'  && !visited[newx][newy]){
                count += _dfs(edge,newx,newy,visited,n);
            }
        }

        return count;
    }

    public  static boolean valid(int x, int y, int n){
        return(x >= 0 && y >= 0 && x < n && y < n);
    }

}


 class Runner69 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());


        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = LargestPiece.dfs(edge,edge.length);
        System.out.println(ans);
    }
}
package graph;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class GetPathDFS {

    public static ArrayList<Integer> getPathHelper(int [][]edges, int si, int ei, boolean []visited){
        if(si == ei){
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(ei);
            return ans;
        }
        visited[si] = true;
        for(int i = 0;i < edges.length; i++){
            if(edges[si][i] == 1 && !visited[i]){
                ArrayList<Integer> smallAns = getPathHelper(edges,i,ei,visited);
                if(smallAns != null){
                    smallAns.add(si);
                    return smallAns;
                }
            }
        }

        return null;
    }

    public static ArrayList<Integer> getPath(int [][]edges,int si, int ei){
        boolean []visited = new boolean[edges.length];
        return getPathHelper(edges, si, ei,visited);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int edges[][] = new int[n][n];

        for(int i = 0;i < e; i++){
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }

        int si = s.nextInt();
        int ei = s.nextInt();
        ArrayList<Integer> ans = getPath(edges,si,ei);
        if(ans != null){
            for(int x : ans){
                System.out.print(x + " ");
            }
        }
    }
}
package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class AllConnectedComponents {


    private static ArrayList<ArrayList<Integer>> getAllConnectedComponents(int[][] edges) {
        boolean []visited = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < edges.length;i++){
            if(!visited[i]) {
                ArrayList<Integer> smallAns = getpath(edges, i, visited);
                ans.add(smallAns);
            }
        }
        return ans;
    }

    private static ArrayList<Integer> getpath(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        visited[sv] = true;
        q.add(sv);

        while (!q.isEmpty()){
            int front = q.remove();
            ans.add(front);
            for(int i = 0;i < edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return ans;
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

        ArrayList<ArrayList<Integer>> ans = getAllConnectedComponents(edges);
        if(ans != null){
            for(ArrayList<Integer> x : ans){
                System.out.println(x);
            }
        }
    }


}

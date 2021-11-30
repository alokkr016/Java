package graph;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IsConnected {
    public static void checkDFS(int [][]edges, int si,boolean [] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[si] = true;
        q.add(si);

        while (!q.isEmpty()){
            int front = q.remove();
            for(int i = 0; i < edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static boolean isConnected(int [][]edges){
        if(edges.length == 0){
            return true;
        }
        boolean []visited = new boolean[edges.length];
        checkDFS(edges,0,visited);
        for(int i = 0; i < edges.length;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
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

//        int si = s.nextInt();
//        int ei = s.nextInt();
        System.out.println(isConnected(edges));
    }

}
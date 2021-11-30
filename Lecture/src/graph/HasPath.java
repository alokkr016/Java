package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class HasPath {
    public static boolean hasPath(int [][]edges, int si, int ei){
        boolean visited[] = new boolean[edges.length];
            return helper(edges,si, visited,ei);
    }
//Using DFS
    public static boolean helper(int [][]edges, int si, boolean [] visited, int ei){
        visited[si] = true;
        if(si > edges.length - 1 || ei > edges.length - 1){
            return false;
        }
        if(edges[si][ei] == 1){
            return true;
        }
        for(int i = 0;i < edges.length;i++){
            if(edges[si][i] == 1 && !visited[i]){
                if( helper(edges,  i, visited,  ei)){
                    return true;
                }

            }
        }
        return false;
    }
    //using BFS
    public static boolean helper2(int [][]edges, int si, boolean [] visited, int ei){
        if(si > edges.length - 1 || ei > edges.length - 1){
            return false;
        }
        if(edges[si][ei] == 1){
            return true;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[si] = true;
        q.add(si);

        while(!q.isEmpty()){
            int front = q.remove();
            for(int i = 0;i < edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]){
                    if(i == ei){
                        return true;
                    }
                    else{
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int [][]edges = new int[n][n];
        for(int i = 0;i < e;i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }
        int si = s.nextInt();
        int ei = s.nextInt();
        System.out.println(hasPath(edges,si,ei));
    }

}

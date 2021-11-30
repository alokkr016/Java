package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class BFSTraversal {

    public static void printHelper(int [][]edges,int sv,boolean []visited){
        Queue<Integer> q = new LinkedList<>();
        visited[sv] = true;
        q.add(sv);

        while (!q.isEmpty()){
            int front = q.remove();
            System.out.print(front + " ");
            for(int i = 0;i < edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);

                }
            }
        }
    }
    public static void print(int [][] edges){
        boolean []visited = new boolean[edges.length];
        for(int i = 0;i < edges.length;i++) {
            if (!visited[i]) {
                printHelper(edges, i, visited);
            }
        }
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

        print(edges);
    }
}


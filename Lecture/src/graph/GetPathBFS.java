package graph;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GetPathBFS {

    public static ArrayList<Integer> getPathHelper(int[][] edges, int si, int ei,boolean [] visited){
        if(si == ei){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(si);
            return ans;
        }
        Queue<Integer> q = new LinkedList<>();
        visited[si] = true;
        q.add(si);
        HashMap<Integer,Integer> hash = new HashMap<>();
//        boolean found = false;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int i = 0; i < edges.length;i++){
                if(edges[front][i] == 1 && !visited[i]) {
                    hash.put(i, front);
                    visited[si] = true;
                    q.add(i);
                    if (i == ei) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(ei);
                        int value = hash.get(ei);
                        while (value != si) {
                            ans.add(value);
                            value = hash.get(value);
                        }
                        ans.add(value);
                        return ans;
                    }
                }
            }

        }

        return null;
    }
    public static ArrayList<Integer> getpathBFS(int [][]edges, int si, int ei){
        boolean []visited = new boolean[edges.length];
        return getPathHelper(edges, si, ei,visited);
    }
    public static void main(String[] args)  throws NumberFormatException, IOException{
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
        ArrayList<Integer> ans =  getpathBFS(edges,si,ei);
        if(ans != null){
            for(int x : ans){
                System.out.print(x + " ");
            }
        }
    }
}
package graph;

import java.util.Scanner;
/*
An island is a small piece of land surrounded by water .
A group of islands is said to be connected if we can reach from any given island
to any other island in the same group . Given V islands (numbered from 1 to V) and E
connections or edges between islands.
Can you count the number of connected groups of islands.
 */
public class Islands {
    public static  void getPathCount(int [][]edges,int sv,boolean visited[]){
        visited[sv] = true;
        for(int i = 0;i < edges.length;i++){
            if(edges[sv][i] == 1 && !visited[i]){
                getPathCount(edges, i, visited);
            }
        }
    }
    public static int getCount(int [][]edges){
        boolean []visited = new boolean[edges.length];
        int count = 0;
        for(int i = 0;i < edges.length;i++){
            if(!visited[i]){
                getPathCount(edges,i,visited);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
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
        System.out.println(getCount(edges));
    }


}

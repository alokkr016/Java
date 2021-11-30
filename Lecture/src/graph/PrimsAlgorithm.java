package graph;

import java.util.Scanner;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e =s.nextInt();
        int adjacencyMatrix[][] = new int[v][v];
        for (int i = 0;i < e;i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }

        prim(adjacencyMatrix);
    }

    private static void prim(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean []visited = new boolean[v];
        int weight[] = new int[v];
        int parent[] = new int[v];

        weight[0] = 0;
        for(int i = 1;i < v;i++){
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        for(int i = 0;i < v;i++){
            int vertex = findMinimumWeight(weight,visited);
            visited[vertex] = true;
            for (int j = 0;j < v;j++) {
                if(adjacencyMatrix[vertex][j] != 0 && !visited[j]){
                    if(adjacencyMatrix[vertex][j] < weight[j]){
                        weight[j] = adjacencyMatrix[vertex][j];
                        parent[j] = vertex;
                    }
                }
            }
        }

        for(int i = 1;i < v;i++){
            if(parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
            else{
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }

    private static int findMinimumWeight(int[] weight, boolean[] visited) {
        int vertex = -1;
        for(int i = 0;i < weight.length;i++){
            if(!visited[i] && (vertex == -1 ||  weight[i] < weight[vertex])){
                vertex = i;
            }
        }
        return vertex;
    }
}

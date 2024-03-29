package graph;

import java.util.Scanner;

public class DijkstrasAlgorithm {
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
        dijkstra(adjacencyMatrix);
    }

    private static void dijkstra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        boolean []visited = new boolean[v];
        int distance[] = new int[v];
        distance[0] = 0;
        for(int i = 1;i < v;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i < v;i++){
            int minVertex = findMinimumVertex(distance,visited);
            for(int j = 0;j < v;j++){
                if(adjacencyMatrix[minVertex][j] != 0 && !visited[j]){
                    int newDistance = adjacencyMatrix[minVertex][j] + distance[minVertex];
                    if(newDistance < distance[j]){
                        distance[j] = newDistance;
                    }
                }
            }
         }

        for(int i = 0;i < adjacencyMatrix.length;i++){
            System.out.println(i + " " + distance[i]);
        }
    }

    private static int findMinimumVertex(int[] weight, boolean[] visited) {
        int vertex = -1;
        for(int i = 0;i < weight.length;i++){
            if(!visited[i] && (vertex == -1 ||  weight[i] < weight[vertex])){
                vertex = i;
            }
        }
        return vertex;
    }
}

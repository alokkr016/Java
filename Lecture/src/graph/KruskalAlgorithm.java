package graph;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
public class KruskalAlgorithm {

    private static int findParent(int v, int parent[]){
        if(parent[v] == v){
            return v;
        }
        return findParent(parent[v], parent);
    }

    public static void kruskal(Edge input[], int n){
        Edge output[] = new Edge[n - 1];

        int parent[] = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        Arrays.sort(input);

        int count = 0;
        int i = 0;

        while(count != n - 1){
            Edge currentEdge = input[i];
            int sourceParent = findParent(currentEdge.source,parent);
            int destinationParent = findParent(currentEdge.destination,parent);
            if(sourceParent != destinationParent){
                output[count] = currentEdge;
                count++;
                parent[sourceParent] = destinationParent;
            }
            i++;
        }

        for (int j = 0;j < n - 1;j++){
            System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int E = in.nextInt();

        Edge []input = new Edge[E];
        for(int i = 0;i < E;i++){
            input[i] = new Edge();
            input[i].source =  in.nextInt();
            input[i].destination = in.nextInt();
            input[i].weight = in.nextInt();
        }

        kruskal(input,N);
    }
}

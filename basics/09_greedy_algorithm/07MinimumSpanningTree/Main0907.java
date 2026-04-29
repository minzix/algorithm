import java.util.ArrayList;
import java.util.Scanner;

class Edge {
    int v1;
    int v2;
    int cost;

    public Edge (int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class Main0907 {
    public static int find(int v, int[] parent){
        if (v == parent[v]) return v;
        else return parent[v] = find(parent[v], parent);
    }
    public static void union(int v1, int v2, int[] parent){
        int rootA = find(v1, parent);
        int rootB = find(v2, parent);
        if (rootA != rootB) parent[rootA] = rootB;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); // 도시의 개수 (노드)
        int E = sc.nextInt(); // 도로의 개수 (간선)
        ArrayList<Edge> graph = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Edge(v1, v2, cost));
        }

        graph.sort((a, b) -> a.cost - b.cost);


    }
}

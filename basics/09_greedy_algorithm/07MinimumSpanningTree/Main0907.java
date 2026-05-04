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
        int answer=0;
        int[] parent = new int[V+1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        for(Edge ob : graph){
            int fv1 = find(ob.v1, parent);
            int fv2 = find(ob.v2, parent);
            if(fv1 != fv2){
                answer += ob.cost;
                union(ob.v1, ob.v2, parent);
            }
        }
        System.out.println(answer);
    }
}

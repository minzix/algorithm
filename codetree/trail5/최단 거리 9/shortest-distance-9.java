import java.util.*;

class Edge {
    int n;
    int w;
    Edge (int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {
    static int n, m, start, end;
    static List<List<Edge>> graph;
    static int[] distance;
    static int[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        path = new int[n];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        start = sc.nextInt() - 1;
        end = sc.nextInt() - 1;
        
        dijkstra();

        System.out.println(distance[end]);
        
        List<Integer> route = new ArrayList<>();
        int v = end;
        while (v != start) {
            route.add(v + 1);
            v = path[v];               // 직전 정점으로 이동
        }
        route.add(start + 1);
        Collections.reverse(route);
        for (int r : route) {
            System.out.print(r + " ");
        }
    }
    
    private static void dijkstra () {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        distance[start] = 0;
        pq.add(new Edge(start, 0)); // re

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.w == distance[cur.n]) {
                for (Edge next : graph.get(cur.n)) {
                    int weight = next.w + cur.w;
                    if (distance[next.n] > weight) {
                        distance[next.n] = weight;
                        // distance가 갱신되는 노드만 path에 기록
                        path[next.n] = cur.n;
                        pq.add(new Edge(next.n, weight));
                    }
                }
            }
        } 
    }
}
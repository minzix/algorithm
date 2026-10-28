import java.util.*;

class Edge {
    int node;
    int weight;

    Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Main {
    static int n;
    static boolean[] visited;
    static int answer;
    static List<List<Edge>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n];
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = sc.nextInt();
                if (weight == 0) continue; // 0은 이동할 수 없음을 뜻한다. 
                graph.get(i).add(new Edge(j, weight));
            }
        }
        answer = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    private static void dfs(int current, int count, int weight) { 
        if (count == n) {
            // 마지막 노드와 0이 연결되었는지 확인
            boolean connected = false;
            for (Edge e : graph.get(current)) {
                if (e.node == 0) {
                    weight += e.weight;
                    connected = true;
                }
            }
            if (!connected) return;

            answer = Math.min(answer, weight);
            return;
        }

        for (Edge next : graph.get(current)) {
            if (!visited[next.node]) {
                visited[next.node] = true;
                dfs(next.node, count + 1, weight + next.weight);
                visited[next.node] = false;
            }
        }
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0707 {

    public static void shortestPathPerNode(int start, int N, ArrayList<ArrayList<Integer>> graph, int[] distance, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true; // 1번 정점 방문 체크
        distance[start] = 0;   // 1번에서 1번까지 거리는 0
        queue.offer(start);    // BFS 시작 정점 넣기

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 정점에서 갈 수 있는 다음 정점들 탐색
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true; // 방문 체크
                    distance[next] = distance[current] + 1; // 현재 정점 거리 + 1
                    queue.offer(next); // 다음 탐색 대상에 추가
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        /*
         * 정점 번호가 1번부터 N번까지이므로
         * 인덱스 0은 사용하지 않고, N번까지 만들기 위해 <= N
         *
         * graph[1] = [3, 4]
         * graph[2] = [1, 5]
         * graph[3] = [4]
         * graph[4] = [5, 6]
         * graph[5] = []
         * graph[6] = [2, 5]
         */
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph.get(from).add(to);
        }

        // 1번 정점에서 출발
        shortestPathPerNode(1, N, graph, distance, visited);

        // 2번 정점부터 N번 정점까지 최단거리 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(i + " : " + distance[i]);
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main0706 {
    public static int countPaths(int current, int N, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        if (current == N) return 1; // 종료 조건
        int count = 0;
        // 현재 정점(current)에서 갈 수 있는 다음 정점들(next) 탐색
        for (int next : graph.get(current)) { // 예: graph[1] = [2, 3, 4] 이므로 current = 1 일 때 next = [2, 3, 4]
            if (!visited[next]) {
                visited[next] = true;      // 방문 체크
                count += countPaths(next, N, graph, visited); // 다음 정점 탐색
                visited[next] = false;     // 되돌아오기
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        /*
         * graph[1] = [2, 3, 4]
         * graph[2] = [1, 3, 5]
         * graph[3] = [4]
         * graph[4] = [2, 5]
         * graph[5] = []
         */
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }
        visited[1] = true; // 1번 정점에서 출발
        System.out.println(countPaths(1, N, graph, visited)); // 현재 current 정점에 있을 때, N번 정점까지 갈 수 있는 경로의 개수를 반환
    }
}
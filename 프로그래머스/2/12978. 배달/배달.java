import java.util.*;

class Point {
    int node;
    int weight;
    Point(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수
        int answer = 0;
        
        List<List<Point>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int weight = r[2];
            graph.get(a).add(new Point(b, weight));
            graph.get(b).add(new Point(a, weight));
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[1] = 0; // 시작점
        pq.add(new Point(1, 0));
        
        while (!pq.isEmpty()) {
            Point current = pq.poll();
            if (current.weight == distance[current.node]) {
                for (Point next : graph.get(current.node)) {
                    int w = next.weight + current.weight;
                    if (distance[next.node] > w) {
                        distance[next.node] = w;
                        pq.add(new Point(next.node, w));
                    }
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) answer++;
        }
        return answer;
    }
}
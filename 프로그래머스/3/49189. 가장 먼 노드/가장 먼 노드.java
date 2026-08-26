import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 양방향 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] e : edge) {
            List<Integer> tmp0 = graph.get(e[0]);
            tmp0.add(e[1]);
            
            List<Integer> tmp1 = graph.get(e[1]);
            tmp1.add(e[0]);
            
            graph.set(e[0], tmp0);
            graph.set(e[1], tmp1);
        }
        
        // BFS
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int s = queue.size();
            answer = s;
            while (s > 0) {
                int current = queue.poll();
                List<Integer> next = graph.get(current);
                for (int nt : next) {
                    if (!visited[nt]) {
                        queue.add(nt);
                        visited[nt] = true;
                    }
                } 
                s--;
            }
        }
        return answer;
    }
}
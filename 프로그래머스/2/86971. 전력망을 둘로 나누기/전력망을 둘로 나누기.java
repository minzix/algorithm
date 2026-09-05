import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    List<List<Integer>> graph;
    boolean[] visited;
    int[] subtree;
    
    public int solution(int n, int[][] wires) {
        visited = new boolean[n + 1];       
        subtree = new int[n + 1];             
        graph = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) subtree[i] = 1;
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
            
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        dfs(1);
        
        for (int s : subtree) answer = Math.min(Math.abs(n - s * 2), answer);
        
        return answer;
    }
    
    private void dfs(int v) {
        List<Integer> sub = graph.get(v);
        for (int s : sub) {
            if (!visited[s]) {
                visited[s] = true;
                dfs(s);
                subtree[v] += subtree[s];
            }
        }
    }
}
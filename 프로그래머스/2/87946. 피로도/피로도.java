import java.util.*;

// 최소 필요 피로도, 소모 피로도
class Solution {
    int[][] dungeons;
    boolean[] visited;
    int minK = 1000;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        
        for (int[] dungeon : dungeons) minK = Math.min(minK, dungeon[0]);
        dfs(k, 0);
        return answer;
    }
    
    public void dfs(int currentK, int count) {       
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                int requiredK = dungeons[i][0];
                int consumeK = dungeons[i][1];
                
                if (requiredK <= currentK) {
                    visited[i] = true;
                    dfs(currentK - consumeK, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
class Solution {
    int answer = 0;
    int[][] dungeons;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        // int[][] dungeons = ["최소 필요 피로도", "소모 피로도"] 
        // k = 현재 피로도
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        
        dfs(k, 0);
        
        return answer;
    }
    
    private void dfs(int k, int count) {
        answer = Math.max(answer, count);
        if (count == dungeons.length) return;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
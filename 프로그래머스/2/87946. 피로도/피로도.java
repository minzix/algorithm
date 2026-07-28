class Solution {
    int[][] dungeons;
    boolean[] visited;
    int answer;
    public int solution(int k, int[][] dungeons) {
        this.answer = -1;
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        
        dfs(k, 0);        
        return answer;
    }
    
    private void dfs(int k, int dungeonCount){
        answer = Math.max(answer, dungeonCount);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (dungeons[i][0] > k) continue;
            
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeonCount + 1);
            visited[i] = false;
        }
    }
}
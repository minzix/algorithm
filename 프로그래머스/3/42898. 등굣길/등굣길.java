class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] puddle = new boolean[n][m];
        for (int[] p : puddles) puddle[p[1]-1][p[0]-1] = true;
        // 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!puddle[y][x]) {
                    // 왼쪽, 위쪽 보기
                    int left = 0;
                    int top = 0;
                    if (x - 1 >= 0) left = dp[y][x-1];
                    if (y - 1 >= 0) top = dp[y-1][x];
                    
                    if (x == 0 && y == 0) dp[y][x] = 1;
                    else dp[y][x] = (left + top) % 1000000007;
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}
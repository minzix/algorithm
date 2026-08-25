import java.util.*;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int[][] maps;
    public int solution(int[][] maps) {        
        this.maps = maps;
        int answer = bfs(0, 0);
        return answer;
    }
    
    public int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        
        int level = 1;
        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s > 0) {
                Point p = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && maps[ny][nx] == 1) {
                        if (nx == m - 1 && ny == n - 1) return level + 1;
                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
                s--;
            }
            level++;
        }
        return -1;
    }
}
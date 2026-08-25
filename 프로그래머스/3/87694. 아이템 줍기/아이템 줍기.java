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
    // [수정] 좌표 최대 50 × 2 = 100, 바깥 검사용 여유까지 102
    static final int SIZE = 102; 
    int itemX;
    int itemY;
    int[][] board;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // [수정] 아이템 좌표도 2배
        this.itemX = itemX * 2;  
        this.itemY = itemY * 2;  
        this.board = new int[SIZE][SIZE]; 
        
        for (int[] rect : rectangle) {
            // [수정] 모든 좌표 2배 확장
            int minX = rect[0] * 2;  
            int minY = rect[1] * 2;  
            int maxX = rect[2] * 2; 
            int maxY = rect[3] * 2;  
            
            for (int i = minY; i <= maxY; i++) {
                for (int j = minX; j <= maxX; j++) board[i][j] = 1;
            }
        }
        
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, 1, -1, 1, -1}; 
        
        for (int y = 0; y < SIZE; y++) {      
            for (int x = 0; x < SIZE; x++) {  
                if (board[y][x] == 1) {
                    boolean isEdge = false;
                    for (int k = 0; k < 8; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[ny][nx] == 0) isEdge = true;
                    }
                    if (isEdge) board[y][x] = 2;
                }
            }
        }
        // [수정] 시작 좌표도 2배로, 결과 거리는 2로 나눠서 원래 스케일로 환원
        return bfs(new Point(characterX * 2, characterY * 2)) / 2;
    }
    
    public int bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[SIZE][SIZE]; 
        queue.add(p);
        visited[p.y][p.x] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point tmp = queue.poll();
                if (tmp.x == itemX && tmp.y == itemY) return level;
                for (int k = 0; k < 4; k++) {
                    int nx = tmp.x + dx[k];
                    int ny = tmp.y + dy[k];
                    if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[ny][nx] == 2 && !visited[ny][nx]) {
                        queue.add(new Point(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }
}
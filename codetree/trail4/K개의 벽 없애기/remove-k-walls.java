import java.util.*;

class Point {
    int x;
    int y;
    int k;
    Point (int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}

public class Main {
    static int n, k, starty, startx, endy, endx;
    static int[][] grid;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        starty = sc.nextInt() - 1;
        startx = sc.nextInt() - 1;
        endy = sc.nextInt() - 1;
        endx = sc.nextInt() - 1;

        visited = new boolean[n][n][k+1];
        
        System.out.println(bfs());
        
        // 최단거리문제는 BFS로 풀기............
        // k처럼 상태값 관리해줘야 하는 게 있으면 visited 에 같이 추가하면 된다구 함
        // visited = [행][열][부순 벽 수]로 3차원
    }

    private static int bfs () {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startx, starty, 0));
        visited[starty][startx][0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Point cur = queue.poll();
                if (cur.x == endx && cur.y == endy) {
                    return level;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (isRange(nx, ny) && !visited[ny][nx][cur.k]) {
                        if (grid[ny][nx] == 0) {
                            queue.add(new Point(nx, ny, cur.k));
                            visited[ny][nx][cur.k] = true;
                        } else if (grid[ny][nx] == 1 && cur.k != k) {
                            queue.add(new Point(nx, ny, cur.k+1));
                            visited[ny][nx][cur.k] = true;
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }
}
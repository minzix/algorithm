import java.util.*;

class Point {
    int x;
    int y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] selected;
    static int[][] grid;
    static int n, k, u, d, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        answer = 0;

        grid = new int[n][n];
        selected = new int[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    // 시작점을 고를 dfs: 중복 X, 조합
    private static void dfs (int start, int count) {
        if (count == k) {
            answer = Math.max(bfs(), answer);
            return;
        }
        for (int i = start; i < n * n; i++) {
            selected[count] = i;
            dfs(i + 1, count + 1);
        }
    }

    private static int bfs () {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int cord : selected) {
            int x = cord % n;
            int y = cord / n;

            queue.add(new Point(x, y));
            visited[y][x] = true;
        }

        int visitCount = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            visitCount++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isRange(nx, ny) && !visited[ny][nx]) {
                    int diff = Math.abs(grid[cur.y][cur.x] - grid[ny][nx]);
                    if (u <= diff && diff <= d) {
                        queue.add(new Point(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return visitCount;
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }
}
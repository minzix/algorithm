import java.util.*;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, k, m, answer;
    static int[][] grid, startPoints;
    static List<Point> stones;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        grid = new int[n][n];
        selected = new int[m];
        stones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    stones.add(new Point(j, i));
                }
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }
        
        dfs(0, 0);

        System.out.println(answer);
    }

    // 치울 돌의 위치 결정하는 조합 중복X dfs
    private static void dfs (int count, int start) {
        if (count == m) {
            moveStones(0);
            bfs();
            moveStones(1);
            return;
        }
        for (int i = start; i < stones.size(); i++) {
            selected[count] = i;
            dfs(count + 1, i + 1);
        }
    }

    private static void bfs () {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int count = 0;

        for (int[] start : startPoints) {
            queue.add(new Point(start[1], start[0]));
            visited[start[0]][start[1]] = true;
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isRange(nx, ny) && !visited[ny][nx] && grid[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        answer = Math.max(answer, count);
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    private static void moveStones (int val) {
        for (int idx : selected) {
            Point stone = stones.get(idx);
            grid[stone.y][stone.x] = val;
        }
    }
}
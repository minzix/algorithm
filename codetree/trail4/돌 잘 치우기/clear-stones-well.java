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
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;

    static int n, k, m, answer;
    static List<Point> stones;
    static int[][] grid, startPoints;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자의 크기
        k = sc.nextInt(); // 시작점의 개수 
        m = sc.nextInt(); // 치울 수 있는 돌의 개수 

        answer = 0;
        stones = new ArrayList<>();
        visited = new boolean[n][n];
        grid = new int[n][n];
        
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

    // 각 시작점마다 bfs 로 방문 가능한 정점 개수 반환 (start 포함)
    // 돌을 치우는 경우의 수를 계산해야함 -> 돌 배열을 만들고, 그 중 m개를 뽑는 경우의 수를 dfs로 구하기
    private static void dfs (int start, int count) {
        if (count == m) {
            for (int[] startPoint : startPoints) {
                bfs(new Point(startPoint[1], startPoint[0]));
            }         
            answer = Math.max(answer, init());
            return;
        }

        for (int i = start; i < stones.size(); i++) {
            Point s = stones.get(i);
            grid[s.y][s.x] = 0;
            dfs(i + 1, count + 1);
            grid[s.y][s.x] = 1;
        }
    }

    private static void bfs (Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isRange(nx, ny) && !visited[ny][nx] && grid[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    private static int init () {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    cnt++;
                    visited[i][j] = false;
                }
            }
        }
        return cnt;
    }
}
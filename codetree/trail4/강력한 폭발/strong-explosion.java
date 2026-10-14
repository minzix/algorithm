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
    static int[][] grid;
    static int n;
    static List<Point> bombPoints;
    static int answer; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        bombPoints = new ArrayList<>();
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) bombPoints.add(new Point(j, i));
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if (idx == bombPoints.size()) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) sum++;
                }
            }
            answer = Math.max(sum, answer);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            Point p = bombPoints.get(idx);
            bomb(1, i, p.x, p.y);
            dfs(idx + 1);
            bomb(-1, i, p.x, p.y);
        }
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    private static void bomb(int op, int type, int startX, int startY) {
        int[] dx = new int[5];
        int[] dy = new int[5];

        if (type == 1) { // 세로
            dx = new int[] {0, 0, 0, 0, 0};
            dy = new int[] {2, 1, 0, -1, -2};
        }
        if (type == 2) { // 십자
            dx = new int[] {0, -1, 1, 0, 0};
            dy = new int[] {0, 0, 0, 1, -1};
        }
        if (type == 3) { // X자
            dx = new int[] {0, -1, -1, 1, 1};
            dy = new int[] {0, 1, -1, 1, -1};
        }

        for (int i = 0; i < 5; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (isRange(nx, ny)) grid[ny][nx] += op;
        }
    }
}
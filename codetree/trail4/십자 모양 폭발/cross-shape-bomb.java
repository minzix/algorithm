import java.util.*;

public class Main {
    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int starty = sc.nextInt() - 1;
        int startx = sc.nextInt() - 1;
        
        bomb(startx, starty);
        gravity();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }

    private static void bomb (int x, int y) {
        int val = grid[y][x];

        grid[y][x] = 0; // 시작점

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int v = 1; v < val; v++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i] * v;
                int ny = y + dy[i] * v;

                if (isRange(nx, ny)) {
                    grid[ny][nx] = 0;
                }
            }
        }
    }

    private static void gravity () {
        for (int x = 0; x < n; x++) {
            List<Integer> list = new ArrayList<>();
            for (int y = n - 1; y >= 0; y--) {
                if (grid[y][x] != 0) list.add(grid[y][x]);
            }
            int idx = list.size();
            if (idx == n || idx == 0) continue;
            int i = 0;
            for (int y = n - 1; y >= 0; y--) {
                if (i >= idx) grid[y][x] = 0;
                else {
                    grid[y][x] = list.get(i);
                    i++;
                }
            }
        }
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }
}
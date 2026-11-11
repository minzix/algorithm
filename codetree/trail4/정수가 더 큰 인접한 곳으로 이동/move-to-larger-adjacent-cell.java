import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int y = sc.nextInt() - 1;
        int x = sc.nextInt() - 1;
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        move(x, y);
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    private static void move (int x, int y) {
        boolean moved = true;
        while (moved) {
            System.out.print(grid[y][x] + " ");
            moved = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isRange(nx, ny) && grid[ny][nx] > grid[y][x]) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }
        }
    }
}
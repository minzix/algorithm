import java.util.*;

public class Main {
    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int answer = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                for (int k = 0; k < n * 2; k++) {
                    int goldCount = diamond(x, y, k);
                    if (m * goldCount >= (k * k + (k + 1) * (k + 1))) {
                        answer = Math.max(answer, goldCount);
                    }
                }
            }
        }
        
        System.out.println(answer);
    }


    private static int diamond (int x, int y, int k) {
        int gold = 0;

        for (int dy = -k; dy <= k; dy++) {
            for (int dx = -k; dx <= k; dx++) {
                if (Math.abs(dy) + Math.abs(dx) <= k) {
                    int nx = x + dx;
                    int ny = y + dy;

                    if (isRange(nx, ny) && grid[ny][nx] == 1) gold++;
                }
            }
        }
        return gold;
    }

    private static boolean isRange (int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }
}
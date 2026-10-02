import java.util.Scanner;

public class Main {
    static int n;
    static int m;

    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                answer = Math.max(blocks(x, y), answer);
            }
        }
        System.out.println(answer);
    }

    private static boolean inRange (int x, int y) {
        return 0 <= x && 0 <= y && x < m && y < n;
    }

    private static int blocks (int x, int y) { // 시작점
        int max = 0;
        int[][] diffX = new int[6][3];
        int[][] diffY = new int[6][3];

        diffX[0] = new int[] {0, 0, 1};
        diffY[0] = new int[] {0, 1, 0};

        diffX[1] = new int[] {0, 0, 1};
        diffY[1] = new int[] {0, -1, 0};

        diffX[2] = new int[] {0, 0, -1};
        diffY[2] = new int[] {0, -1, 0};

        diffX[3] = new int[] {0, 0, -1};
        diffY[3] = new int[] {0, 1, 0};

        diffX[4] = new int[] {0, 1, 2};
        diffY[4] = new int[] {0, 0, 0};

        diffX[5] = new int[] {0, 0, 0};
        diffY[5] = new int[] {0, -1, -2};

        for (int i = 0; i < 6; i++) {
            int sum = 0;
            boolean inrange = true;
            for (int j = 0; j < 3; j++) {
                int nx = diffX[i][j] + x;
                int ny = diffY[i][j] + y;

                if (inRange(nx, ny)) sum += grid[ny][nx];
                else inrange = false;
            }
            if (inrange) max = Math.max(sum, max);
        }    
        return max;
    }
}
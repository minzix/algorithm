import java.util.*;

public class Main {
    static int[][] building;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt(); // 바람의 개수

        building = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();

        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt() - 1; // 각 바람 별 직사각형 정보

        for (int i = 0; i < q; i++) { 
            int top = queries[i][0];
            int left = queries[i][1];
            int bottom = queries[i][2];
            int right = queries[i][3];

            circulate(top, left, bottom, right);

            int[][] copy = new int[n][m]; 
            for (int y = 0; y < n; y++)
                copy[y] = building[y].clone();

            for (int y = top; y <= bottom; y++)
                for (int x = left; x <= right; x++)
                    mean(copy, x, y);
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                System.out.print(building[y][x] + " ");
            }
            System.out.println();
        }
    }

    private static void mean(int[][] copy, int x, int y) {
        int sum = copy[y][x]; 
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny)) {
                sum += copy[ny][nx];
                cnt++;
            }
        }
        building[y][x] = sum / cnt; 
    }

    private static boolean isRange(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    private static void circulate(int top, int left, int bottom, int right) {
        int prev = building[top + 1][left];

        for (int x = left; x < right; x++) {
            int tmp = building[top][x];
            building[top][x] = prev;
            prev = tmp;
        }
        for (int y = top; y < bottom; y++) {
            int tmp = building[y][right];
            building[y][right] = prev;
            prev = tmp;
        }
        for (int x = right; x > left; x--) {
            int tmp = building[bottom][x];
            building[bottom][x] = prev;
            prev = tmp;
        }
        for (int y = bottom; y > top; y--) {
            int tmp = building[y][left];
            building[y][left] = prev;
            prev = tmp;
        }
    }
}
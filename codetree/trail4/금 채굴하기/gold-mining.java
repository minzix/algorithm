import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int k = 1;
        int answer = 0;

        while (true) {
            if (k == (2 * n + 1)) break;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {

                    int gain = diamond(x, y, k);

                    // 문제의 K = 현재 코드의 k - 1
                    int cost = (k - 1) * (k - 1) + k * k;

                    if (gain * m >= cost) { // 손해를 보지 않는다면 저장
                        answer = Math.max(answer, gain);
                    }
                }
            }
            k++;
        }
        System.out.println(answer);
    }

    private static int diamond(int x, int y, int k) {
        int diamondCount = 0;

        for (int ny = 0; ny < n; ny++) {
            for (int nx = 0; nx < n; nx++) {

                if (Math.abs(nx - x) + Math.abs(ny - y) < k) {
                    diamondCount += grid[ny][nx];
                }
            }
        }

        return diamondCount;
    }
}
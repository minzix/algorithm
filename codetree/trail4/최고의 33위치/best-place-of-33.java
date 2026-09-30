import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int sum = 0;
                if (x + 2 < n && y + 2 < n) {
                    for (int k = 0; k < 3; k++) {
                        for (int m = 0; m < 3; m++) {
                            if (grid[y + k][x + m] == 1) sum++;   
                        }
                    }
                }
                answer = Math.max(answer, sum);
            }
        }
        System.out.println(answer);
    }
}
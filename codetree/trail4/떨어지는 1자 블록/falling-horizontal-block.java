import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // 1 은 블럭이 채워져있음. 
        int y = 0;
        while (y < n) {
            boolean isAvail = true;
            for (int x = k; x < k + m; x++) {
                if (grid[y][x] == 1) {
                    isAvail = false;
                }
            }
            if (!isAvail) break;
            else y++;
        }
        for (int x = k; x < k + m; x++) {
            grid[y - 1][x] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
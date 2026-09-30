import java.util.Scanner;
  
public class Main {
    static int n;
    static int m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (isHappyW(i)) answer++;
            if (isHappyH(i)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isHappyW (int x) {
        if (m == 1) return true;
        int count = 1;
        for (int y = 1; y < n; y++) {
            if (grid[y][x] == grid[y-1][x]) count++;
            else count = 1;
            if (count >= m) return true;
        }
        return false;
    }

    private static boolean isHappyH (int y) {
        if (m == 1) return true;
        int count = 1;
        for (int x = 1; x < n; x++) {
            if (grid[y][x] == grid[y][x-1]) count++;
            else count = 1;
            if (count >= m) return true;
        }
        return false;
    }
}
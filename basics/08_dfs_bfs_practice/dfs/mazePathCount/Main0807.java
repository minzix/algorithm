import java.util.Scanner;

public class Main0807 {
    static int[][] maze;
    static int WIDTH = 7, HEIGHT = 7, count = 0;
    public static void dfs (int x, int y) {
        if (x == WIDTH - 1 && y == HEIGHT - 1) {
            count++;
            return;
        }
        // 출발점: maze[y][x]
        if (y > 0) if (maze[y - 1][x] == 0) {
            maze[y - 1][x] = 2;
            dfs(x, y - 1);
            maze[y - 1][x] = 0;
        }
        if (y < HEIGHT - 1) if (maze[y + 1][x] == 0) {
            maze[y + 1][x] = 2;
            dfs(x, y + 1);
            maze[y + 1][x] = 0;
        }
        if (x > 0) if (maze[y][x - 1] == 0) {
            maze[y][x - 1] = 2;
            dfs(x - 1, y);
            maze[y][x - 1] = 0;
        }
        if (x < WIDTH - 1) if (maze[y][x + 1] == 0) {
            maze[y][x + 1] = 2;
            dfs(x + 1, y);
            maze[y][x + 1] = 0;
        }

    }
    public static void main(String[] args) {
        maze = new int[WIDTH][HEIGHT];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < HEIGHT; i++) for (int j = 0; j < WIDTH; j++) maze[i][j] = sc.nextInt();
        maze[0][0] = 2;
        dfs(0, 0);
        System.out.println(count);
    }
}

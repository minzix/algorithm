import java.util.Scanner;

public class Main0807 {
    static int[][] maze;
    static int WIDTH = 7, HEIGHT = 7, count = 0;
    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs (int x, int y) {
        if (x == WIDTH - 1 && y == HEIGHT - 1) {
            count++;
            return;
        }
        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 배열 범위 안에 있고, 이동 가능한 통로라면
            if (nextX >= 0 && nextX < WIDTH && nextY >= 0 && nextY < HEIGHT && maze[nextY][nextX] == 0) {
                maze[nextY][nextX] = 1; // 방문 체크
                dfs(nextX, nextY);
                maze[nextY][nextX] = 0; // 백트래킹
            }
        }
    }
    public static void main(String[] args) {
        maze = new int[WIDTH][HEIGHT];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < HEIGHT; i++) for (int j = 0; j < WIDTH; j++) maze[i][j] = sc.nextInt();
        maze[0][0] = 1;
        dfs(0, 0);
        System.out.println(count);
    }
}

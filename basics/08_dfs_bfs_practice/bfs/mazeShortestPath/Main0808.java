import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main0808 {
    static int[][] maze;
    static int WIDTH = 7, HEIGHT = 7, answer = -1;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};

    public static void bfs(int level, Queue<Point> queue) {
        if (queue.isEmpty()) return;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point current = queue.poll();
            if (current.x == WIDTH - 1 && current.y == HEIGHT - 1) {
                answer = level;
                return;
            }
            for (int j = 0; j < 4; j++) {
                int nextX = current.x + dx[j];
                int nextY = current.y + dy[j];
                if (nextX >= 0 && nextY >= 0 && nextX < WIDTH && nextY < HEIGHT && maze[nextY][nextX] == 0) {
                    maze[nextY][nextX] = 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
        bfs(level + 1, queue);
    }
    public static void main(String[] args) {
        maze = new int[WIDTH][HEIGHT];
        Queue<Point> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < HEIGHT; i++) for (int j = 0; j < WIDTH; j++) maze[i][j] = sc.nextInt();
        maze[0][0] = 1;
        queue.add(new Point(0, 0));
        bfs(0, queue);
        System.out.println(answer);
    }
}

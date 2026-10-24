import java.util.*;

class Point {
    int x;
    int y;
    int l;
    Point(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }
}

class Solution {
    static int width;
    static int height;
    static char[][] map;

    public int solution(String[] maps) {
        int answer = 0;
        width = maps[0].length();
        height = maps.length;
        
        map = new char[height][width];

        int y = 0;
        Point start = new Point(0, 0, 0);
        for (String m : maps) {
            int x = 0;
            for (char c : m.toCharArray()) {
                map[y][x] = c;
                if (c == 'S') start = new Point(x, y, 0);
                x++;
            }
            y++;
        }
        System.out.println(Arrays.deepToString(map));

        // 통행 가능: 시작점 (S), 출구(E), 레버(L), 통로(O)
        // 통행 불가: 벽(X)
        // 레버를 당긴 후 출구칸에 도달해야 탈출할 수 있음
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[height][width][2];
        queue.add(start);
        visited[start.y][start.x][start.l] = true;

        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s > 0) {
                Point current = queue.poll();
                if (map[current.y][current.x] == 'E' && current.l == 1) {
                    return answer;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + current.x;
                    int ny = dy[i] + current.y;

                    if (isRange(nx, ny)) {
                        int isPulled = current.l;
                        if (map[ny][nx] == 'L') isPulled = 1;
                        if (!visited[ny][nx][isPulled] && map[ny][nx] != 'X') {
                            visited[ny][nx][isPulled] = true;
                            queue.add(new Point(nx, ny, isPulled));
                        }
                    }
                } 
                s--;
            }
            answer++;
        }
        return -1;
    }

    private boolean isRange(int x, int y) {
        return 0 <= x && 0 <= y && x < width && y < height;
    }
}
import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	static int N = 16;
	static Point end;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		// start = 2, end = 3
		// start ~ end 길이 있는가?
		// bfs, boolean isAvail 변수로 체크
		for (int t = 1; t <= T; t++) {
			br.readLine();
			
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			Point start = new Point(0, 0);
			end = new Point(0, 0);
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				int j = 0;
				for (char c : str.toCharArray()) {
					arr[i][j] = c - '0';
					if (arr[i][j] == 2) {
						start.x = j;
						start.y = i;
					}
					if (arr[i][j] == 3) {
						end.x = j;
						end.y = i;
					}
					j++;
				}
			}
			System.out.println("#" + t + " " + bfs(start));
		}
	}
	
	private static int bfs (Point start) {
		// 1 : 가능함, 0 : 가능하지 않음 
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		visited[start.y][start.x] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur.x == end.x && cur.y == end.y) {
				return 1;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				
				if (isRange(nx, ny) && !visited[ny][nx] && arr[ny][nx] != 1) {
					visited[ny][nx] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}

		return 0;
	}
	
	private static boolean isRange (int x, int y) {
		return 0 <= x && 0 <= y && x < N && y < N;
	}
}

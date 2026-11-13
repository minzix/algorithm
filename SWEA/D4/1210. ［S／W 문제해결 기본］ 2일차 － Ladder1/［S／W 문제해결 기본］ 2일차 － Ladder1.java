import java.util.*;
import java.io.*;

class Solution {
	// x표시에서 거꾸로 올라가면서 어느 막대의 시작점에 도착하는지 시뮬레이션
	static int N = 100;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for (int t = 1; t <= T; t++) {		
			br.readLine();
			int[][] arr = new int[N][N];
			
			int endx = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						endx = j;
					}
				}
			}
			
			int y = N - 1;
			int x = endx;
			
			int[] dx = {-1, 1};
			
			while (y > 0) {
				for (int i = 0; i < 2; i++) {
					int nx = dx[i] + x;
					if (isRange(nx) && arr[y][nx] == 1) {
						while (isRange(nx + dx[i]) && arr[y][nx + dx[i]] == 1) {
							nx += dx[i];
						}
						x = nx;
						break;
					}
				}
				y--;
			}
			
			System.out.println("#" + t + " " + x);
		}
	}
	
	private static boolean isRange (int x) {
		return 0 <= x && x < N;
	}
}

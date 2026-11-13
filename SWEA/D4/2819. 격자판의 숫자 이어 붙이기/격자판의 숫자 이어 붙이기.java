
import java.util.*;
import java.io.*;

class Solution {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N = 4;
	static int[] selected; // value
	static int answer;
	static int[][] arr;
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception {
		// 조합 중복 X dfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			arr = new int[N][N];
			answer = 0;
			selected = new int[7];
			set = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(j, i, 0);
				}
			}
			
			System.out.println("#" + t + " " + set.size());
		}
		
	}
	
	private static void dfs (int x, int y, int count) {
		if (count == 7) {
			//System.out.println(Arrays.toString(selected));
			StringBuilder sb = new StringBuilder();
			for (int s : selected) sb.append(s);
			set.add(Integer.parseInt(sb.toString()));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if (isRange(nx, ny)) {
				selected[count] = arr[ny][nx];
				dfs(nx, ny, count + 1);
			}
		}
	}
	
	private static boolean isRange (int x, int y) {
		return 0 <= x && 0 <= y && x < N && y < N;
	}
}

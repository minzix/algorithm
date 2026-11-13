import java.util.*;
import java.io.*;

class Solution {
	
	static int N, B, answer;
	static int[] heights;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			
			heights = new int[N];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st1.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + (answer - B));
		}
	}
	
	private static void dfs (int idx, int h) {
		if (h >= B) {
			answer = Math.min(h, answer);
			return;
		}
		
		if (idx == N) return;
		
		dfs(idx + 1, h + heights[idx]);
		dfs(idx + 1, h);
	}
}

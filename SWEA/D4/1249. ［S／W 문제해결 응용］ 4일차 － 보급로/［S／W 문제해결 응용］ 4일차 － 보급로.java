import java.util.*;
import java.io.*;

class Edge {
	int n;
	int w;
	Edge (int n, int w) {
		this.n = n;
		this.w = w;
	}
}

class Solution {
	// 출발지 s (0, 0) -> 도착지 g (n-1, n-1) 
	// 각 칸의 수만큼의 시간 소요 
	// 왜 MST가 아니라 다익스트라?
	// 두 정점 사이의 최단거리만 구해야 하고, 이 과정에서 각 정점간의 거리는 반드시 최단일 필요가 없음 
	
	static int n, answer;
	static int[][] map;
	static int[] distance;
	static List<List<Edge>> graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			
			distance = new int[n*n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			graph = new ArrayList<>();
			for (int i = 0; i < n*n; i++) graph.add(new ArrayList<>());
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				int j = 0;
				for (char c : str.toCharArray()) {
					map[i][j] = c - '0';
					j++;
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int d = 0; d < 4; d++) {
						int nx = dx[d] + j;
						int ny = dy[d] + i;
						if (isRange(nx, ny)) {
							graph.get(i*n+j).add(new Edge(ny*n+nx, map[ny][nx]));
						}						
					}
				}
			}
			
			dijkstra();
			
			System.out.println("#" + t + " " + distance[n*n-1]);
		}
	}
	
	private static void dijkstra () {
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		pq.add(new Edge(0, 0));
		distance[0] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.w == distance[cur.n]) {
				for (Edge next : graph.get(cur.n)) {
					int weight = cur.w + next.w;
					if (weight < distance[next.n]) {
						distance[next.n] = weight;
						pq.add(new Edge(next.n, weight));
					}
				}
			}
		}
	}
	
	private static boolean isRange (int x, int y) {
		return 0 <= x && 0 <= y && x < n && y < n;
	}
}

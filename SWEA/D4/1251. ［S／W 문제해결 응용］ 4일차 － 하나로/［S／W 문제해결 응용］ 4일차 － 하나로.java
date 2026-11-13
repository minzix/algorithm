import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            // 입력
            int N = Integer.parseInt(br.readLine().trim());
            int[][] points = new int[N][2]; // [i][0] = x, [i][1] = y

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    points[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            double E = Double.parseDouble(br.readLine().trim());

            // 초기화
            boolean[] visited = new boolean[N];
            long[] distance = new long[N];
            Arrays.fill(distance, Long.MAX_VALUE);
            distance[0] = 0;
            long total = 0;

            // Prim
            for (int p = 0; p < N; p++) {
                // 가장 가까운 섬 고르기
                int idx = -1; // 섬 번호
                long val = Long.MAX_VALUE; // 거리 값 
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && distance[i] < val) {
                    	val = distance[i];
                        idx = i;
                    }
                }

                // 트리에 넣기
                visited[idx] = true;
                total += val;

                // 거리 갱신
                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        long d = diff(points[idx], points[i]);
                        if (d < distance[i]) {
                        	distance[i] = d;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + Math.round(total * E));
        }
    }

    private static long diff(int[] a, int[] b) {
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
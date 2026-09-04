import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return 0;
        });
        
        int camera = routes[0][1];
        int answer = 1;
        
        for (int i = 1; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                answer++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}
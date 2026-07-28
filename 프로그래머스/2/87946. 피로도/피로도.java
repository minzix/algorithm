import java.util.*;

// 피로도 시스템 (0 이상) 
// 각 던전마다 최소 피로도 (던전을 탐험하기 위해 가지고 있어야 하는 min 피로도), 
// 소모 피로도 (각 던전을 탐험하고 나면 차감되는 피로도)가 있음
// 하나의 던전은 하루에 한번만 탐험 가능, 던전은 여러개임
// 유저가 탐험할 수 있는 최대 던전 개수 반환

// dungeons = [[최소 피로도, 소모 피로도], [], ...]
// k = 유저의 현재 피로도

class Solution {

    int answer = 0;
    boolean[] visited;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];

        dfs(k, 0);
        return answer;
    }

    private void dfs(int k, int count) {

        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i]) continue;
            if (k < dungeons[i][0]) continue;

            visited[i] = true;
            dfs(k - dungeons[i][1], count + 1);
            visited[i] = false; 
        }
    }
}
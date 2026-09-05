import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        // 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while (left < right) {
            // 각 지점 사이의 거리의 최솟값
            int mid = left + (right - left + 1) / 2;
            
            int prev = 0;
            int remove = 0;
            for (int rock : rocks) {
                if (rock - prev < mid) remove++;
                else prev = rock;
            }
            if (distance - prev < mid) remove++;
            
            // remove가 n보다 작거나 같아야 함. 나머지 바위들은 아무데서나 제거해도 mid가 젤 작은 gap임. 
            if (remove <= n) {
                answer = Math.max(answer, mid);
                left = mid;
            } else right = mid - 1;
        }
        
        return answer;
    }
}
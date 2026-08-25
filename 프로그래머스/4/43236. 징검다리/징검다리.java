import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        // "모든 간격이 mid 이상이 되게 하려면 바위를 최소 몇 개 제거해야 하나?"
        // mid = 간격
        // 모든 간격이 mid 이상이 되게 한다 
        // = rocks 를 0부터 순회하며 diff를 구해서 mid 이하인 diff를 만드는 돌을 제거 (remove)
        // remove < n : mid 는 달성가능함. 최대한 큰 값을 찾아야 하므로 위쪽 절반을 가져감. 
        int left = 0; 
        int right = distance;
        int mid = (left + right) / 2;
        
        
        while (left <= right) {
            int remove = 0;
            int prev = 0;                  // 마지막으로 남긴 지점
            
            for (int rock : rocks) {
                if (rock - prev < mid) remove++;
                else prev = rock;
            }
            
            if (distance - prev < mid) remove++;   // 마지막 원소 검사 추가
            
            if (remove <= n) {             // 가능 → 더 큰 mid 탐색
                answer = mid;
                left = mid + 1;
            } else {                       // 불가능 → 줄이기
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return answer;
    }
}
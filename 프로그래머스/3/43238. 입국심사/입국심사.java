import java.util.*;

// 구해야 하는 것: 모든 사람이 심사를 받는데 걸리는 시간 -> min  
class Solution {
    public long solution(int n, int[] times) { // 사람 수 n, 각 심사대 대기시간 times[]    
        Arrays.sort(times);
        
        // 최대, 최소 소요시간
        long left = 0;
        // 모든 사람이 젤 오래 걸리는 심사대에서 기다려서 심사받은 시간
        long right = (long) times[times.length - 1] * n; 
        long answer = right; 
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            // mid 시간 내로 모든 사람이 심사를 받을 수 있나? 
            long people = 0; // 총 심사 가능한 사람
            for (int time : times) { // 각 심사대에서 한 명 심사하는데 걸리는 시간
                people += (mid / time);
            }
            
            if (people >= n) {
                answer = Math.min(mid, answer);
                right = mid;
            } else left = mid + 1;
        }
        return answer;
    }
}
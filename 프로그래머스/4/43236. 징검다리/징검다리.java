import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0; 
        int right = distance;
        int len = rocks.length;
        
        Arrays.sort(rocks);
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int remove = 0;
            int prev = 0;
            
            for (int i = 0; i < len; i++) {
                int gap = rocks[i] - prev;
                
                if (gap < mid) remove++;
                else prev = rocks[i];
            }
            if (distance - prev < mid) remove++;
            
            if (remove > n) right = mid - 1;
            else {
                left = mid;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
}
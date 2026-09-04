import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long max = (long) times[times.length - 1] * (long) n;
        
        Arrays.sort(times);
        
        long left = 0;
        long right = max;
        long answer = max;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            long ppl = 0;
            for (int t : times) ppl += (mid / t);
            
            if (ppl >= n) { 
                answer = Math.min(answer, mid);
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
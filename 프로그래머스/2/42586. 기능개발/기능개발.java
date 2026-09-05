import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int len = progresses.length;
        int idx = 0;
        
        while (idx < len) {
            int day = (100 - progresses[idx]) / speeds[idx];
            if ((100 - progresses[idx]) % speeds[idx] != 0) day += 1;
            int count = 0;
            
            while (idx < len && progresses[idx] + speeds[idx] * day >= 100) {
                idx++;
                count++;
            }
            ans.add(count);
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return 0;
        });

        int rs = 0; 
        int re = 0;
        
        int count = 0;
        
        for (int[] target : targets) {
            int ts = target[0];
            int te = target[1];
            
            if (re <= ts || te <= rs) {
                rs = ts;
                re = te;
            } else {
                if (rs < ts && ts < re) rs = ts;
                if (rs < te && te < re) re = te;
                count++;
            }       
        }
        return targets.length - count;
    }
}
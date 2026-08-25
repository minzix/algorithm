import java.util.*;

class Solution {
    String target;
    String[] words;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;      
        return bfs(begin);
    }
    
    public int bfs(String begin) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        int level = 0;
        
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                String tmp = queue.poll();
                if (tmp.equals(target)) return level;
                for (int i = 0; i < words.length; i++) {
                    if (!visited[i]) {
                        int diff = 0;
                        for (int j = 0; j < words[i].length(); j++) {
                            if (tmp.charAt(j) != words[i].charAt(j)) diff++;
                        }
                        if (diff == 1) {
                            queue.add(words[i]);
                            visited[i] = true;
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }
}
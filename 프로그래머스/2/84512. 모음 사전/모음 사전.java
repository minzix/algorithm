import java.util.*;

class Solution {
    ArrayList<String> dict;
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {        
        dict = new ArrayList<>();
        dfs("", 0);
        
        Collections.sort(dict);
        return dict.indexOf(word) + 1;
    }
    private void dfs(String word, int depth) {
        if (depth == 5) return;
        for (char c : alpha) {
            String w = word + c;
            dict.add(w);
            dfs(w, depth + 1);

        }
    }
}
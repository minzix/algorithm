import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {        
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int p : parent) set.add(find(p));
        
        return set.size();
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) parent[a] = b;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] parent = new int[computers.length + 1];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= computers.length; i++) parent[i] = i;
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    if (parent[i+1] != parent[j+1]) {
                        // 수정: 두 parent가 모두 set에 있는 경우를 먼저 처리
                        if (set.contains(parent[i+1]) 
                                && set.contains(parent[j+1])) {
                            
                            int tmp = parent[j+1];
                            for (int k = 1; k <= computers.length; k++) {
                                if (parent[k] == tmp) {
                                    parent[k] = parent[i+1];
                                }
                            }
                            set.remove(tmp);
                            
                        } 
                        if (set.contains(parent[i+1])) parent[j+1] = parent[i+1];
                        else if (set.contains(parent[j+1])) parent[i+1] = parent[j+1];
                        else {
                            set.add(parent[i+1]);
                            parent[j+1] = parent[i+1];
                        } 
                    }
                }
            }
        }
        for (int p : parent) System.out.println(p);
        Set<Integer> tmp = new HashSet<>();
        for (int i = 1; i <= computers.length; i++) tmp.add(parent[i]);
        
        return tmp.size();
    }
}
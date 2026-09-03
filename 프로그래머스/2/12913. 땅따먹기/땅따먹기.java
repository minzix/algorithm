class Solution {
    int solution(int[][] land) {
        int answer = 0;
                
        for (int y = 1; y < land.length; y++) {
            for (int i = 0; i < 4; i++) {
                int max = 0;
                for (int j = 0; j < 4; j++) {
                    if (i != j) max = Math.max(max, land[y-1][j]);
                }
                land[y][i] += max;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
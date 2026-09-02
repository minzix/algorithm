class Solution {
    public int solution(int[][] triangle) {
        
        for (int y = triangle.length - 1; y > 0; y--) {
            int[] current = triangle[y];
            
            int upperIdx = 0;
            for (int x = 0; x < current.length - 1; x++) {
                int max = Math.max(current[x], current[x + 1]);
                triangle[y - 1][upperIdx] += max; 
                upperIdx++;
            }
        } 
        return triangle[0][0];
    }
}
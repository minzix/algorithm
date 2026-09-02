class Solution {
    public int solution(int[][] triangle) {
        
        for (int y = triangle.length - 1; y > 0; y--) {
            int[] current = triangle[y];
            
            for (int x = 0; x < current.length - 1; x++) {
                int max = Math.max(current[x], current[x + 1]);
                triangle[y - 1][x] += max; 
            }
        } 
        return triangle[0][0];
    }
}
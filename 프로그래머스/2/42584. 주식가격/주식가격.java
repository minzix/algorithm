import java.util.*;

// 가격이 떨어진다 = i보다 큰 인덱스의 값 중 i 인덱스의 값보다 작은게 있다. 
// i 전의 값들은 비교할 필요가 없음
// for (0 ~ ) 로 순회하고, 그 안에서 for (i ~ )로 한번 더 순회함

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 끝까지 가격이 떨어지지 않는 경우는 if문에 걸리지 않으므로 기본값으로 초기화된 0을 잘못 반환함
        for (int i = 0; i < prices.length; i++) {
            // 초기화
            answer[i] = prices.length - i - 1;
            for (int j = i; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    // 가격이 떨어지지 않은 기간 = i ~ j
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
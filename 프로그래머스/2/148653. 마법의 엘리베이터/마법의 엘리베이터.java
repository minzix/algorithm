class Solution {
    private int answer;
    private char[] storeys;

    public int solution(int storey) {
        answer = 0;
        storeys = Integer.toString(storey).toCharArray();

        for (int i = storeys.length - 1; i >= 0; i--) {
            int n = storeys[i] - '0';
            int upCnt = 10 - n;
            int downCnt = n;

            if (upCnt < downCnt) { // 6~9
                up(i, n);
            } else if (upCnt > downCnt) { // 0~4
                down(n);
            } else { // 5
                if (i == 0) {
                    down(n); // 맨 앞자리 5 = 올림 6번, 내림 5번
                } else {
                    int next = storeys[i - 1] - '0';
                    if (next >= 5) up(i, n);
                    else down(n);
                }
            }
        }
        return answer;
    }

    private void up(int i, int n) {
        int upCnt = 10 - n;
        if (i == 0) { // 맨 앞자리
            answer += upCnt + 1;            
        } else {
            answer += upCnt;
            storeys[i - 1] += 1;
        }
    }

    private void down(int n) {
        answer += n;
    }
}
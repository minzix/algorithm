import java.util.Arrays;

// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 문자열을 사전순 정렬하면, 어떤 문자열의 접두사가 되는 문자열은 반드시 바로 앞에 위치
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }
}
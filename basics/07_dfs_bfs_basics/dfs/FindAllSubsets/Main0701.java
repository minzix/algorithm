import java.util.*;

// 1 ~ N까지의 원소를 가지는 집합의 부분집합 구하기
public class Main0701 {
    // 현재 숫자를 부분집합에 넣을지 말지 결정하는 방식으로 구현
    public static void findSubsets(int start, int end, boolean[] selected) {
        if (start > end) { // 종료 조건
            String subset = "";
            for (int num = 1; num <= end; num++) if (selected[num]) subset += (num + " "); // 선택된 숫자만 subset 문자열에 추가
            if (subset.length() > 0) System.out.println(subset); // 공집합이 아니라면 출력
        } else { // 현재 숫자 start를 부분집합에 넣는 경우와 안 넣는 경우 둘 다 탐색
            selected[start] = true;                        // start를 부분집합에 포함
            findSubsets(start + 1, end, selected);    // 다음 숫자에 대해 재귀 호출
            selected[start] = false;                       // start를 부분집합에 포함하지 않음
            findSubsets(start + 1, end, selected);    // 다음 숫자에 대해 재귀 호출
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = 1;
        int end = sc.nextInt();
        boolean[] selected = new boolean[end + 1];
        findSubsets(start, end, selected);                   // start부터 부분집합 탐색 시작
    }
}
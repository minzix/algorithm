import java.util.*;

// 1 ~ N까지의 원소를 가지는 집합의 부분집합 구하기
public class Main0701 {
    // 현재 숫자를 부분집합에 넣을지 말지 결정하는 방식으로 구현
    public static void findSubsets(int currentNum, int N, int[] selected) {
        if (currentNum == N + 1) {                               // 종료 조건
            String subset = "";
            for (int i = 0; i < N; i++) {
                if (selected[i] == 1) subset += (i + 1 + " ");   // 선택된 숫자만 subset 문자열에 추가
            }
            if (subset.length() > 0) System.out.println(subset); // 공집합이 아니라면 출력
        } else {
            selected[currentNum - 1] = 1;                        // currentNum를 부분집합에 포함
            findSubsets(currentNum + 1, N, selected);  // 다음 숫자에 대해 재귀 호출
            selected[currentNum - 1] = 0;                        // currentNum를 부분집합에 포함하지 않음
            findSubsets(currentNum + 1, N, selected);  // 다음 숫자에 대해 재귀 호출
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] selected = new int[N];
        findSubsets(1, N, selected);                   // 1부터 부분집합 탐색 시작
    }
}
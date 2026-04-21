import java.util.*;

public class Main0701 {
    // 원소가 N개인 집합의 부분집합의 개수는 2**N개이다 (공집합 포함)
    // 현재 숫자를 부분집합에 넣을지 말지 결정하는 방식으로 구현
    public static void DFS(int currentNum, int N, int[] selected) {
        if (currentNum == N + 1) { // 종료 조건
            String subset = "";

            for (int num = 1; num <= N; num++) {
                if (selected[num] == 1) subset += (num + " "); // 선택된 숫자만 subset 문자열에 추가
            }

            if (subset.length() > 0) System.out.println(subset); // 공집합이 아니라면 출력
        } else {
            selected[currentNum] = 1; // currentNum를 부분집합에 포함
            DFS(currentNum + 1, N, selected); // 다음 숫자에 대해 재귀 호출

            selected[currentNum] = 0; // currentNum를 부분집합에 포함하지 않음
            DFS(currentNum + 1, N, selected); // 다음 숫자에 대해 재귀 호출
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1 ~ N까지의 원소를 가지는 집합의 부분집합 구하기
        int[] selected = new int[N + 1]; // 1번 인덱스부터 사용하기 위해 크기를 N + 1로 생성
        DFS(1, N, selected); // 1부터 시작해서 부분집합 탐색 시작
    }
}
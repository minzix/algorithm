import java.util.Scanner;
/*
* 조합이란? nCr 일 때, 순서 없이 n개 중에서 r개를 선택하는 경우의 수
* 예: (A, B), (B, A) 는 같은 경우의 수이므로 count 는 1번만 함
*/
public class Main0805 {
    static int[][] memo;
    public static int combination(int n, int r) {
        if (memo[n][r] > 0) return memo[n][r]; // 저장된 값이 있으면 바로 반환
        if (r == 0 || n == r) return 1; // 종료 조건: nC0 또는 nCn은 항상 1
        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[n + 1][r + 1]; // n, r 범위의 메모이제이션 배열 생성, 초기값은 모두 0
        System.out.println(combination(n, r));
    }
}
import java.util.Scanner;

public class Main0805 {
    static int[][] memo;
    public static int combination(int n, int r) {
        if (memo[n][r] > 0) return memo[n][r];
        if (r == 0 || n == r) return 1;
        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[n + 1][r + 1]; // n, r 범위의 메모이제이션 배열 생성
        System.out.println(combination(n, r));
    }
}
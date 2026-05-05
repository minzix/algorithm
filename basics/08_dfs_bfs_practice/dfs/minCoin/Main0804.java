import java.util.Arrays;
import java.util.Scanner;

public class Main0804 {
    static int total, N, answer;
    static int[] coins;
    public static void subset(int count, int sum) {
        if (count >= answer) return;
        if (sum > total) return;
        if (sum == total) answer = Math.min(answer, count);
        else {
            for (int i = N - 1; i >= 0; i--) {
                subset(count + 1, sum + coins[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        total = sc.nextInt();
        Arrays.sort(coins);
        answer = Integer.MAX_VALUE;
        subset(0, 0);
        System.out.println(answer);
    }
}

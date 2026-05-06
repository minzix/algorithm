import java.util.Scanner;

public class Main1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        // dp[i] = arr[i] 를 마지막 항으로 하는 최대증가수열의 길이로, 전부 1로 초기화한다. 자기 자신만 선택해도 최소 길이가 1이기 때문이다.
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }
        int answer = 0;

        for (int i = 0; i < N; i++) {
            // dp[i]를 dp[j] + 1로 갱신
            for (int j = 0; j < i; j++) if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

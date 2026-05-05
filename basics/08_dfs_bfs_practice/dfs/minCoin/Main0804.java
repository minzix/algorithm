import java.util.Arrays;
import java.util.Scanner;

public class Main0804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        int total = sc.nextInt();
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (total == 0) break;
            count += total / coins[i];
            total = total % coins[i];
        }
        System.out.println(count);
    }
}

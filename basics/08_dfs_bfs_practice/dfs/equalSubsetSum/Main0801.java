import java.util.Scanner;

public class Main0801 {
    static int total, N;
    static String answer = "NO";
    static int[] arr;
    public static void subset(int level, int sum) {
        if (sum > total / 2 || answer.equals("YES")) return;
        if (level == N) {
            if (total == sum * 2) answer = "YES";
        } else {
            subset(level + 1, sum + arr[level]);
            subset(level + 1, sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        if (total % 2 == 1) {
            System.out.println("NO");
        } else {
            subset(0, 0);
            System.out.println(answer);
        }
    }
}

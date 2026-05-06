import java.util.Scanner;

// DP: 문제를 작은 단위로 쪼개서 정복함 (divide-and-conquer, bottom-up)
public class Main1001 {
    public static void main(String[] args) {
        // 피보나치
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < N; i++) arr[i] = arr[i-1] + arr[i-2];
        System.out.println(arr[N-1]);
    }
}

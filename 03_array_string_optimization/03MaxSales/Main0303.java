import java.util.Scanner;

public class Main0303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = k; i < N; i++){
            sum = sum + arr[i] - arr[i-k];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

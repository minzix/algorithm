import java.util.Scanner;

public class Main0304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열 길이
        int M = sc.nextInt(); // 합이 M이 되는 부분수열 구하기
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0, left = 0;
        int count = 0;
        // 합이 M 넘음: left++, sum - arr[left]
        // 합이 M 안됨: right++, sum + arr[right] : while문
        // 합이 M 같음: answer++, right++
        for (int right = 0; right < N; right++){
            sum += arr[right];
            while (sum > M) {
                sum -= arr[left];
                left++;
            }
            if (sum == M) count++;
        }
        System.out.println(count);
    }
}

import java.util.Scanner;

public class Main0206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            String temp = new StringBuilder(sc.next()).reverse().toString();
            arr[i] = Integer.parseInt(temp);
            if (isPrime(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

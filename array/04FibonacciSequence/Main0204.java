import java.util.Scanner;

public class Main0204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() ; // 3<=N<=45
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        System.out.print("1 1 ");

        for (int i = 0; i < N - 2; i++) {
            arr[i + 2] = arr[i] + arr[i + 1];
            System.out.print(arr[i + 2] + " ");
        }
    }
}

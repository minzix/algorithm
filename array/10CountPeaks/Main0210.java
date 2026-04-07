import java.util.Scanner;

public class Main0210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 2;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0 || i == N-1 || j == N-1) arr[i][j] = 0;
                else arr[i][j] = sc.nextInt();
            }
        }
        // arr[i][j]
        // 상: arr[i][j+1]
        // 하: arr[i][j-1]
        // 좌: arr[i-1][j]
        // 우: arr[i+1][j]
        int count = 0;
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                int max = Math.max(Math.max(arr[i][j+1], arr[i][j-1]), Math.max(arr[i-1][j], arr[i+1][j]));
                if (max < arr[i][j]) count ++;
            }
        }
        System.out.println(count);
    }
}

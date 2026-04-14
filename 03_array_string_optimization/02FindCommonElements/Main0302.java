import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main0302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++){
            B[i] = sc.nextInt();
        }
        int n = 0;
        int m = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        while (n < N && m < M) {
            if (A[n] == B[m]) System.out.print(A[n++] + " ");
            else if (A[n] > B[m]) m++;
            else n++;
        }
    }
}

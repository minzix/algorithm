import java.util.ArrayList;
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
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < M; i++){
            B.add(sc.nextInt());
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            if (B.contains(A[n])) answer.add(A[n]);
        }
        answer.sort(null);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}

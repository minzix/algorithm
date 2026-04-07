import java.util.Scanner;

public class Main0203 {
    public static void main(String[] args) {
        // 1:가위 < 2:바위 < 3:보
        // a + b == 3 -> 2 승
        // a + b == 4 -> 1 승
        // a + b == 5 -> 3 승

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) System.out.println("D");
            else if (A[i] + B[i] == 3) {
                if (A[i] == 2) System.out.println("A");
                else System.out.println("B");
            } else if (A[i] + B[i] == 4) {
                if (A[i] == 1) System.out.println("A");
                else System.out.println("B");
            } else if (A[i] + B[i] == 5) {
                if (A[i] == 3) System.out.println("A");
                else System.out.println("B");
            }
        }
    }
}

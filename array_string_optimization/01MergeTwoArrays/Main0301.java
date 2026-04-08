import java.util.ArrayList;
import java.util.Scanner;

public class Main0301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            arr.add(sc.nextInt());
        }
        arr.sort(null);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}

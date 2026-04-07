import java.util.Scanner;

public class Main0205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] check = new boolean[N + 1];
        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (!check[i]) {
                count++;
                for (int j = i; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }
        System.out.println(count);
    }
}

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(0, n);
    }
    private static void count (int cnt, int n) {
        if (n == 1) {
            System.out.println(cnt);
            return;
        }
        if (n % 2 == 0) count(cnt + 1, n / 2);
        else count(cnt + 1, n / 3);
    }
}
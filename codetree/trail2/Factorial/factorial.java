import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(multi(n));
    }
    private static int multi (int n) {
        if (n == 1) return 1;
        return n * multi(n - 1);
    }
}
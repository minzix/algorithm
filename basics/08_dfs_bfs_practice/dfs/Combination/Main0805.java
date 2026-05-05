import java.util.Scanner;

public class Main0805 {
    public static int combination(int n, int r) {
        if (r == 0 || n == r) return 1; // nC0 = 1, nCn = 1
        // nCr = n-1Cr-1 + n-1Cr
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(combination(n, r));
    }
}
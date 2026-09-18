import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        printMulti(0, 1);
    }
    private static void printMulti(int idx, int current) {
        if (idx == n) {
            System.out.println(current);
            return;
        }
        if (current % arr[idx] == 0) printMulti(idx + 1, current);
        else printMulti(idx + 1, current / gcd(current, arr[idx]) * arr[idx]);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
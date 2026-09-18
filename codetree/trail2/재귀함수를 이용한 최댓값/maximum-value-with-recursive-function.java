import java.util.Scanner;
public class Main {
    static int answer;
    static int[] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        getMax(0);
        System.out.println(answer);
    }
    private static void getMax(int idx) {
        if (idx == n) return;
        answer = Math.max(answer, arr[idx]);
        getMax(idx + 1);
    }
}
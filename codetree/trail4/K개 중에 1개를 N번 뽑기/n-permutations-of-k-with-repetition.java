import java.util.Scanner;

public class Main {
    static int[] selected;
    static int k;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        selected = new int[n];
        dfs(0);
    }
    
    private static void dfs(int idx) {
        if (idx == n) {
            for (int s : selected) System.out.print(s + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= k; i++) {
            selected[idx] = i;
            dfs(idx + 1);
        }
    }
}
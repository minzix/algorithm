import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        
        if (isContains(n1, n2, a, b)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isContains (int n1, int n2, int[] a, int[] b) {
        for (int i = 0; i < n1; i++) {
            if (i + n2 - 1 < n1) {
                boolean isContains = true;
                for (int j = 0; j < n2; j++) {
                    if (a[i + j] != b[j]) isContains = false;
                }
                if (isContains) return true;
            }  
        }
        return false;
    }
}
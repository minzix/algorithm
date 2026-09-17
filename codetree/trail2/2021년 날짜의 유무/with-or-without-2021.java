import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if (isDate(m, d)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isDate(int m, int d) {
        int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m <= 12 && dates[m] >= d) return true;
        else return false;
    }
}
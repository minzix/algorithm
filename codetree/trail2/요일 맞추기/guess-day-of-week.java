import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day1 = d1;
        int day2 = d2;
        
        for (int i = 1; i < m1; i++) day1 += days[i];
        for (int i = 1; i < m2; i++) day2 += days[i];

        int totalDays = day2 - day1;

        System.out.println(numToDay(totalDays % 7));
    }

    private static String numToDay (int n) {
        if (n == 0 || n == -7) return "Mon";
        if (n == 1 || n == -6) return "Tue";
        if (n == 2 || n == -5) return "Wed";
        if (n == 3 || n == -4) return "Thu";
        if (n == 4 || n == -3) return "Fri";
        if (n == 5 || n == -2) return "Sat";
        if (n == 6 || n == -1) return "Sun";
        return "";
    }
}
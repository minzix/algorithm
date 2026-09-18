import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if (isDate(y, m, d)) {
            System.out.println(printSeason(m));
        } else System.out.println(-1);
    }

    private static boolean isDate (int y, int m, int d) {
        int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (y % 4 == 0 && y % 100 != 0) dates[2] = 29;
        if (y % 4 == 0 && y % 100 == 0 && y % 400 == 0) dates[2] = 29;

        if (dates[m] >= d) return true;
        else return false;
    }

    private static String printSeason (int m) {
        String season = "";
        if (3 <= m && m <= 5) season = "Spring";
        else if (6 <= m && m <= 8) season = "Summer";
        else if (9 <= m && m <= 11) season = "Fall";
        else if (m == 12 || m <= 2) season = "Winter";
        return season;
    }
}
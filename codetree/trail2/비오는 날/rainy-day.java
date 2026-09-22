import java.util.*;

class Data {
    String date;
    String day;
    String weather;
    int index;

    Data (String date, String day, String weather, int index) {
        this.date = date;
        this.day = day;
        this.weather = weather;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Data> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            list.add(new Data(date, day, weather, i));
        }
        
        Collections.sort(list, (a, b) -> {
            if (a.date != b.date) return compareDate(a.date, b.date);
            if (a.index != b.index) return a.index - b.index;
            return 0;
        });

        for (Data d : list) {
            if (d.weather.equals("Rain")) {
                System.out.println(d.date + " " + d.day + " " + d.weather);
                return;
            }
        }
    }

    private static int compareDate(String a, String b) {
        // a가 더 작으면 -1, b가 더 작으면 +1
        String[] aInfo = a.split("-");
        String[] bInfo = b.split("-");

        // 연도
        int aYear = Integer.parseInt(aInfo[0]);
        int bYear = Integer.parseInt(bInfo[0]);

        if (aYear > bYear) return 1;
        if (aYear < bYear) return -1;

        // 월
        int aMonth = Integer.parseInt(aInfo[1]);
        int bMonth = Integer.parseInt(bInfo[1]);

        if (aMonth > bMonth) return 1;
        if (aMonth < bMonth) return -1;

        // 일
        int aDay = Integer.parseInt(aInfo[2]);
        int bDay = Integer.parseInt(bInfo[2]);

        if (aDay > bDay) return 1;
        if (aDay < bDay) return -1;

        return 0;
    }
}
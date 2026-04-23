import java.util.ArrayList;
import java.util.Scanner;

public class Main0804 {
    static class Lecture {
        int date;
        int money;

        Lecture(int date, int money) {
            this.date = date;
            this.money = money;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 요청 수
        int maxDate = 0;
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt(); // M: 강연료
            int D = sc.nextInt(); // D: 기한(일자)
            lectures.add(new Lecture(D, M));
            maxDate = Math.max(maxDate, D);
        }
        int[] dates = new int[maxDate];
        lectures.sort((a, b) -> { // money, date 순 내림차순 정렬
            if (a.money == b.money) return b.date - a.date;
            else return b.money - a.money;
        });
        int totalMoney = 0;
        // 1일 1 강연이므로, dueDate - 1 이하인 인덱스의 값이 0인 게 존재하는지 확인
        for (int i = 0; i < N; i++) {
            int dueDate = lectures.get(i).date;
            for (int j = dueDate - 1; j >= 0; j--) {
                if (dates[j] == 0) {
                    dates[j] = lectures.get(i).money;
                    totalMoney += lectures.get(i).money;
                    break;
                }
            }
        }
        System.out.println(totalMoney);
    }
}

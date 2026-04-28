import java.util.*;

public class Main0804 {
    static class Lecture {
        int deadline ;
        int money;

        Lecture(int date, int money) {
            this.deadline  = date;
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
        // 강연들을 date순으로 내림차순 정렬
        lectures.sort((a, b) -> b.deadline  - a.deadline);

        PriorityQueue<Lecture> lectureQueue = new PriorityQueue<>((a, b) -> b.money - a.money);
        int answer = 0, index = 0;

        for (int day = maxDate; day > 0; day--) {
            while (index < N && lectures.get(index).deadline >= day) {
                lectureQueue.add(lectures.get(index));
                index++;
            }
            if (!lectureQueue.isEmpty()) answer += lectureQueue.poll().money; // day 하나마다 한번만 추가
        }
        System.out.println(answer);
    }
}

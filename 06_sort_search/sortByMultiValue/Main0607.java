package sortByMultiValue;

import java.util.*;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main0607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }
        // sort() 안에는 정렬기준을 적음
        list.sort((a, b) -> { // 리스트 원소 두 개 a, b를 비교해서 정렬
            if (a.x != b.x) return a.x - b.x; // x가 다르면 x가 작은 걸 앞에 둠
            return a.y - b.y; // x가 같으면 y가 작은 걸 앞에 둠
        });

        for (Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
